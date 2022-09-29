package com.podolian.vamatestapp.presentation.composables

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.podolian.vamatestapp.R
import com.podolian.vamatestapp.ui.theme.textStyle2
import com.podolian.vamatestapp.ui.theme.textStyle3

enum class ToolbarState {
    COLLAPSED,
    RESTORED
}

@Composable
fun CollapsableToolbar(
    text: String,
    state: ToolbarState,
    collapsedHeight: Dp,
    restoredHeight: Dp,
    topPadding: Dp,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background.copy(alpha = 0.90f))
                .animateContentSize()
                .height(
                    (topPadding + if (state == ToolbarState.RESTORED) {
                        restoredHeight
                    } else {
                        collapsedHeight
                    })
                )
        )
        AnimatedVisibility(
            visible = state == ToolbarState.COLLAPSED,
            modifier = Modifier
                .fillMaxWidth()
                .height(collapsedHeight + topPadding),
            enter = fadeIn(),
            exit = fadeOut(animationSpec = tween(durationMillis = 100))
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                DynamicText(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = dimensionResource(id = R.dimen.padding_small) + topPadding),
                    text = text,
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
        AnimatedVisibility(
            visible = state == ToolbarState.RESTORED,
            modifier = Modifier
                .fillMaxWidth()
                .height(restoredHeight + topPadding),
            enter = slideInVertically(animationSpec = tween(durationMillis = 100)) + fadeIn(
                animationSpec = tween(durationMillis = 100)
            ),
            exit = slideOutVertically(animationSpec = tween(durationMillis = 100)) + fadeOut(
                animationSpec = tween(durationMillis = 100)
            )
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                DynamicText(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(
                            start = dimensionResource(id = R.dimen.padding_middle),
                            top = dimensionResource(id = R.dimen.padding_small) + topPadding
                        ),
                    text = text,
                    style = textStyle3
                )
            }
        }
    }
}
