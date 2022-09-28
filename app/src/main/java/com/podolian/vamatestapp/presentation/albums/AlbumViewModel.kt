package com.podolian.vamatestapp.presentation.albums

import androidx.lifecycle.viewModelScope
import com.podolian.domain.model.Feed
import com.podolian.domain.model.RequestParams
import com.podolian.domain.usecase.FetchAlbumsCase
import com.podolian.vamatestapp.presentation.BaseViewModel
import com.podolian.vamatestapp.presentation.KEY_ERROR_TEXT
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class UiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val feed: Feed? = null,
    val errorData: HashMap<String, Any?>? = null
)

class AlbumViewModel(
    private val fetchAlbumsCase: FetchAlbumsCase
) : BaseViewModel<UiState>(UiState()) {

    init {
        fetchAlbums()
    }

    fun fetchAlbums() {
        viewModelScope.launch {
            fetchAlbumsCase(RequestParams())
                .onStart {
                    _uiState.tryEmit(uiState.value.copy(isLoading = true))
                }
                .catch {
                    val data = HashMap<String, Any?>()
                    data[KEY_ERROR_TEXT] = it.message
                    _uiState.tryEmit(uiState.value.copy(isError = true, errorData = data))
                    it.printStackTrace()
                }
                .collect {
                    _uiState.tryEmit(uiState.value.copy(isLoading = false, feed = it))
                }
        }
    }
}