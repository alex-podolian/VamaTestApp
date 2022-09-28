package com.podolian.vamatestapp.presentation.composables

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.podolian.vamatestapp.utils.resize

@Composable
fun DynamicImage(imageUrl: String, modifier: Modifier) {
    BoxWithConstraints(modifier = modifier) {
        AsyncImage(
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop,
            contentDescription = imageUrl,
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl.resize(constraints.maxWidth, constraints.maxHeight))
                .crossfade(true)
                .build()
        )
    }
}