package com.podolian.vamatestapp.presentation.albums

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.*
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.podolian.domain.model.Feed
import com.podolian.vamatestapp.action.contract.ActionExecutor
import org.koin.androidx.compose.getViewModel
import com.podolian.vamatestapp.R
import com.podolian.vamatestapp.action.OpenErrorScreen
import com.podolian.vamatestapp.action.RetryAction
import com.podolian.vamatestapp.presentation.KEY_RETRY_ACTION
import com.podolian.vamatestapp.presentation.composables.CollapsableToolbar
import com.podolian.vamatestapp.presentation.composables.LoadingIndicator
import com.podolian.vamatestapp.presentation.composables.ToolbarState
import com.podolian.vamatestapp.presentation.composables.VerticalGrid

@Composable
fun AlbumsScreen(
    executor: ActionExecutor? = null
) {
    val viewModel = getViewModel<AlbumViewModel>()
    val state = viewModel.uiState.sync.collectAsState().value

    if (state.isLoading) {
        LoadingIndicator()
    }

    if (state.isError) {
        state.errorData?.let { data ->
            val retryAction = object : RetryAction() {
                override fun invoke() {
                    viewModel.fetchAlbums()
                }
            }
            data[KEY_RETRY_ACTION] = retryAction
            executor?.invoke(OpenErrorScreen(data))
        }
    }

    if (state.feed != null) {
        Content(feed = state.feed, executor = executor)
    }
}

@Composable
fun Content(
    feed: Feed,
    executor: ActionExecutor?
) {
    val contentPadding = dimensionResource(id = R.dimen.padding_middle)
    val restoredToolbarHeight = dimensionResource(id = R.dimen.toolbar_height_restored)
    val collapsedToolbarHeight = dimensionResource(id = R.dimen.toolbar_height_collapsed)

    val lazyGridState = rememberLazyGridState()

    val toolbarState by remember {
        derivedStateOf {
            if (lazyGridState.firstVisibleItemIndex == 0) {
                ToolbarState.RESTORED
            } else {
                ToolbarState.COLLAPSED
            }
        }
    }

    val paddingValues = PaddingValues(
        start = contentPadding,
        top = contentPadding + restoredToolbarHeight + 20.dp,
        end = contentPadding,
        bottom = contentPadding + 40.dp
    )
    VerticalGrid(
        feed = feed,
        columns = 2,
        lazyGridState = lazyGridState,
        executor = executor,
        paddingValues = paddingValues
    )
    CollapsableToolbar(
        text = stringResource(id = R.string.top_albums),
        collapsedHeight = collapsedToolbarHeight,
        restoredHeight = restoredToolbarHeight,
        topPadding = 20.dp,
        state = toolbarState
    )
}