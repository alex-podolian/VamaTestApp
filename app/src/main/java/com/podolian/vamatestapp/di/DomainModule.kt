package com.podolian.vamatestapp.di

import com.podolian.domain.usecase.FetchAlbumsCase
import com.podolian.domain.usecase.FetchAlbumsCaseImpl
import com.podolian.domain.usecase.RetrievePersistedDataCase
import com.podolian.domain.usecase.RetrievePersistedDataCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<FetchAlbumsCase> {
        FetchAlbumsCaseImpl(dataRepository = get())
    }
    factory<RetrievePersistedDataCase> {
        RetrievePersistedDataCaseImpl(dataRepository = get())
    }
}