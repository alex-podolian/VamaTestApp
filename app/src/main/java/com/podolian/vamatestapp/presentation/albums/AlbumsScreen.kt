package com.podolian.vamatestapp.presentation.albums

import androidx.compose.runtime.Composable
import com.podolian.vamatestapp.action.contract.ActionExecutor
import org.koin.androidx.compose.getViewModel

@Composable
fun AlbumsScreen(
    executor: ActionExecutor? = null,
) {
    val viewModel = getViewModel<AlbumViewModel>()
}