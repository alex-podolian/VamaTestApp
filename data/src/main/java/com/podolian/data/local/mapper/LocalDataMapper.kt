package com.podolian.data.local.mapper

import com.podolian.data.local.model.*
import com.podolian.domain.model.*

internal fun LocalGenre.toDomain() = Genre(
    name = this.name,
)

internal fun LocalItemData.toDomain() = ItemData(
    artistName = this.artistName,
    id = this.id,
    name = this.name,
    releaseDate = this.releaseDate,
    artworkUrl100 = this.artworkUrl100,
    genres = this.genres.map { it.toDomain() },
    url = this.url
)


internal fun LocalFeed.toDomain() = Feed(
    copyright = this.copyright,
    id = this.id,
    results = this.results.map { it.toDomain() },
)

internal fun Genre.toLocal() = LocalGenre(
    name = this.name
)

internal fun ItemData.toLocal() = LocalItemData(
    artistName = this.artistName,
    id = this.id,
    name = this.name,
    releaseDate = this.releaseDate,
    artworkUrl100 = this.artworkUrl100,
    genres = this.genres.map { it.toLocal() },
    url = this.url
)

internal fun Feed.toLocal() = LocalFeed(
    copyright = this.copyright,
    id = this.id,
    results = this.results.map { it.toLocal() }
)

