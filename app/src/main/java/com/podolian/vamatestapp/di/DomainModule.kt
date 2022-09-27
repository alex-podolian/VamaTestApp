package com.podolian.vamatestapp.di

import com.podolian.domain.usecase.FetchAlbumsCase
import com.podolian.domain.usecase.FetchAlbumsCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<FetchAlbumsCase> {
        FetchAlbumsCaseImpl(dataRepository = get())
    }
}