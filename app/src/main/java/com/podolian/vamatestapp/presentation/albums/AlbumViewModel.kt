package com.podolian.vamatestapp.presentation.albums

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.podolian.domain.model.RequestParams
import com.podolian.domain.usecase.FetchAlbumsCase
import kotlinx.coroutines.launch

class AlbumViewModel(
    private val fetchAlbumsCase: FetchAlbumsCase
) : ViewModel() {

    init {
        fetchAlbums()
    }

    private fun fetchAlbums() {
        viewModelScope.launch {
            fetchAlbumsCase(RequestParams()).collect {
                Log.d("AlbumviewModel = ", "feed = $it")
//                updateFeedStatusStream.emit(it)
            }
        }
    }

}