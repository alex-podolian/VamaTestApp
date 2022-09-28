package com.podolian.database.di

import com.podolian.data.repository.LocalSource
import com.podolian.database.DatabaseSource
import com.podolian.database.model.*
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.koin.dsl.module

val databaseModule = module {
    single { provideDatabase() }
    single<LocalSource> { DatabaseSource(realm = get()) }
}

fun provideDatabase(): Realm {
    return Realm.open(
        RealmConfiguration.Builder(
            schema = setOf(
                PersistedFeed::class,
                PersistedGenre::class,
                PersistedItemData::class,
            )
        ).build()
    )
}