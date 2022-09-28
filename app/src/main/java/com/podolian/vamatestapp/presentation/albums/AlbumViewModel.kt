package com.podolian.vamatestapp.presentation.albums

import androidx.lifecycle.viewModelScope
import com.podolian.domain.model.Feed
import com.podolian.domain.model.RequestParams
import com.podolian.domain.usecase.FetchAlbumsCase
import com.podolian.vamatestapp.presentation.BaseViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class UiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val feed: Feed? = null
)

class AlbumViewModel(
    private val fetchAlbumsCase: FetchAlbumsCase
) : BaseViewModel<UiState>(UiState()) {

    init {
        fetchAlbums()
    }

    private fun fetchAlbums() {
        viewModelScope.launch {
            fetchAlbumsCase(RequestParams())
                .onStart {
                    _uiState.tryEmit(uiState.value.copy(isLoading = true))
                }
                .catch {
                    _uiState.tryEmit(uiState.value.copy(isError = true))
                    it.printStackTrace()
                }
                .collect {
                    _uiState.tryEmit(uiState.value.copy(isLoading = false, feed = it))
                }
        }
    }
}