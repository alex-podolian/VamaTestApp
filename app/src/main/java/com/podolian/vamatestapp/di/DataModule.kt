package com.podolian.vamatestapp.di

import com.podolian.data.repository.DataRepositoryImpl
import com.podolian.domain.repository.DataRepository
import org.koin.dsl.module

val dataModule = module {
    single<DataRepository> {
        DataRepositoryImpl(localSource = get(), remoteSource = get())
    }
}