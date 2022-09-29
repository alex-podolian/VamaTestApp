package com.podolian.vamatestapp.presentation.composables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

@Composable
fun DynamicText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    textAlign: TextAlign = TextAlign.Left,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis
) {
    Text(
        modifier = modifier,
        text = text,
        style = style,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow
    )
}