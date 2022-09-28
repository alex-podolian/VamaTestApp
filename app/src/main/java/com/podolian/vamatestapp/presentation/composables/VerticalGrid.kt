package com.podolian.vamatestapp.presentation.composables

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.podolian.domain.model.Feed
import com.podolian.domain.model.Result
import com.podolian.vamatestapp.R
import com.podolian.vamatestapp.action.OpenAlbumDetailsScreen
import com.podolian.vamatestapp.action.contract.ActionExecutor
import com.podolian.vamatestapp.ui.theme.Gradient
import com.podolian.vamatestapp.ui.theme.Gray

@Composable
fun VerticalGrid(
    feed: Feed,
    columns: Int,
    lazyGridState: LazyGridState = rememberLazyGridState(),
    executor: ActionExecutor?,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        state = lazyGridState,
        contentPadding = paddingValues,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
        columns = GridCells.Fixed(columns),
        modifier = modifier.animateContentSize()
    ) {
        items(feed.results, key = { it.id }) { data ->
            GridItem(data = data, executor = executor)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GridItem(
    data: Result,
    executor: ActionExecutor?,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.card_corner_radius))),
        onClick = { executor?.invoke(OpenAlbumDetailsScreen(data)) }
    ) {
        DynamicImage(imageUrl = data.artworkUrl100, modifier = Modifier.fillMaxSize())
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Gradient
                        )
                    )
                )
        )
        Column(
            modifier = Modifier
                .padding(all = dimensionResource(id = R.dimen.padding_small))
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = data.name,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp
                )
            )
            Text(
                text = data.artistName,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    color = Gray,
                    fontSize = 12.sp,
                )
            )
        }
    }
}