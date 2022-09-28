package com.podolian.database.mapper

import com.podolian.data.local.model.*
import com.podolian.database.model.*
import io.realm.kotlin.ext.toRealmList

internal fun LocalGenre.toDatabase() = PersistedGenre(
    name = this.name,
)

internal fun LocalItemData.toDatabase() = PersistedItemData(
    artistName = this.artistName,
    id = this.id,
    name = this.name,
    releaseDate = this.releaseDate,
    artworkUrl100 = this.artworkUrl100,
    genres = this.genres.map { it.toDatabase() }.toRealmList(),
    url = this.url
)

internal fun LocalFeed.toDatabase() = PersistedFeed(
    copyright = this.copyright,
    id = this.id,
    results = this.results.map { it.toDatabase() }.toRealmList(),
)

internal fun PersistedGenre.toLocal() = LocalGenre(
    name = this.name,
)

internal fun PersistedItemData.toLocal() = LocalItemData(
    artistName = this.artistName,
    id = this.id,
    name = this.name,
    releaseDate = this.releaseDate,
    artworkUrl100 = this.artworkUrl100,
    genres = this.genres.map { it.toLocal() },
    url = this.url
)

internal fun PersistedFeed.toLocal() = LocalFeed(
    copyright = this.copyright,
    id = this.id,
    results = this.results.map { it.toLocal() },
)
