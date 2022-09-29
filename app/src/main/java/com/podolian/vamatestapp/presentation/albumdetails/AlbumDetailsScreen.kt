package com.podolian.vamatestapp.presentation.albumdetails

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.podolian.domain.model.ItemData
import com.podolian.vamatestapp.R
import com.podolian.vamatestapp.presentation.composables.DynamicImage
import com.podolian.vamatestapp.presentation.composables.DynamicText
import com.podolian.vamatestapp.ui.theme.*
import com.podolian.vamatestapp.utils.formatDate

@Composable
fun AlbumDetailsScreen(
    data: ItemData,
    copyright: String,
    navController: NavController
) {
    val context = LocalContext.current
    Box {
        Column(modifier = Modifier.fillMaxSize()) {
            DynamicImage(
                imageUrl = data.artworkUrl100,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_middle),
                        top = dimensionResource(id = R.dimen.padding_small),
                        end = dimensionResource(id = R.dimen.padding_middle),
                        bottom = dimensionResource(id = R.dimen.padding_bottom)
                    ),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    DynamicText(text = data.artistName, style = MaterialTheme.typography.body1)
                    DynamicText(text = data.name, style = textStyle3)
                    Row(
                        modifier = Modifier
                            .padding(vertical = dimensionResource(id = R.dimen.padding_extra_small))
                    ) {
                        data.genres.forEach { genre ->
                            Box(
                                modifier = Modifier
                                    .padding(end = dimensionResource(id = R.dimen.padding_smallest))
                            ) {
                                Text(
                                    text = genre.name,
                                    style = TextStyle(
                                        color = Blue,
                                        fontSize = 12.sp,
                                    ),
                                    modifier = Modifier
                                        .border(
                                            1.dp,
                                            Blue,
                                            RoundedCornerShape(dimensionResource(id = R.dimen.card_corner_radius))
                                        )
                                        .padding(horizontal = dimensionResource(id = R.dimen.padding_extra_small))
                                        .padding(bottom = 1.dp)
                                )
                            }
                        }
                    }
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    DynamicText(
                        text = stringResource(
                            id = R.string.release_date,
                            data.releaseDate.formatDate(context)
                        ),
                        style = textStyle
                    )
                    DynamicText(
                        modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_large)),
                        text = copyright,
                        style = textStyle
                    )
                    data.url?.let {
                        Button(
                            modifier = Modifier.height(dimensionResource(id = R.dimen.button_height)),
                            onClick = {
                                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                                try {
                                    ContextCompat.startActivity(context, browserIntent, null)
                                } catch (t: Throwable) {
                                    Toast.makeText(
                                        context, R.string.broken_url, Toast.LENGTH_SHORT
                                    ).show()
                                }
                            },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Blue),
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
                            contentPadding = PaddingValues(horizontal = dimensionResource(id = R.dimen.button_padding))
                        ) {
                            DynamicText(
                                text = stringResource(id = R.string.visit),
                                style = textStyle2
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_bottom)))
                }
            }
        }
        val padding = dimensionResource(id = R.dimen.padding_middle)
        FloatingActionButton(
            shape = CircleShape,
            elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp),
            modifier = Modifier
                .padding(
                    start = padding,
                    top = padding + 20.dp,
                    end = padding,
                    bottom = padding
                )
                .size(32.dp),
            onClick = { navController.popBackStack() },
            backgroundColor = White80,
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "Back",
                tint = Dark,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}