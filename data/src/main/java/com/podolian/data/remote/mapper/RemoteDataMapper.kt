package com.podolian.data.remote.mapper

import com.podolian.data.remote.model.*
import com.podolian.domain.model.*

internal fun RemoteGenre.toDomain() = Genre(
    name = this.name
)

internal fun RemoteItemData.toDomain() = ItemData(
    artistName = this.artistName,
    id = this.id,
    name = this.name,
    releaseDate = this.releaseDate,
    artworkUrl100 = this.artworkUrl100,
    genres = this.genres.map { it.toDomain() },
    url = this.url
)

internal fun RemoteFeed.toDomain() = Feed(
    copyright = this.copyright,
    id = this.id,
    results = this.results.map { it.toDomain() },
)

