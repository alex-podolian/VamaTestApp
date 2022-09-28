package com.podolian.vamatestapp.di

import com.podolian.vamatestapp.presentation.albums.AlbumViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val appModule = module {
    viewModel {
        AlbumViewModel(
            fetchAlbumsCase = get(),
            retrievePersistedDataCase = get()
        )
    }
}