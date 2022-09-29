package com.podolian.vamatestapp.presentation.error

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.podolian.vamatestapp.R
import com.podolian.vamatestapp.presentation.composables.DynamicText
import com.podolian.vamatestapp.ui.theme.*

@Composable
fun ErrorScreen(errorText: String, reloadAction: () -> Unit) {
    val context = LocalContext.current as Activity
    val titleText = stringResource(R.string.no_internet_connection)
    val btnRetryText = stringResource(R.string.retry)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(R.drawable.ic_no_connection),
                contentDescription = "Error occurred",
                contentScale = ContentScale.Fit,
            )
            DynamicText(
                modifier = Modifier.padding(top = 24.dp, start = 36.dp, end = 36.dp),
                text = titleText,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body2,
                maxLines = 2
            )
            DynamicText(
                modifier = Modifier.padding(top = 14.dp, start = 36.dp, end = 36.dp),
                text = errorText,
                textAlign = TextAlign.Center,
                style = textStyle,
                maxLines = 2
            )
            Button(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 36.dp, end = 36.dp)
                    .height(dimensionResource(id = R.dimen.button_height)),
                colors = ButtonDefaults.buttonColors(backgroundColor = Blue),
                shape =  RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
                contentPadding = PaddingValues(horizontal = dimensionResource(id = R.dimen.button_padding)),
                onClick = { reloadAction() }
            ) {
                DynamicText(
                    text = btnRetryText,
                    style = textStyle2
                )
            }
        }
    }

    BackHandler(enabled = true) {
        context.finish()
    }
}