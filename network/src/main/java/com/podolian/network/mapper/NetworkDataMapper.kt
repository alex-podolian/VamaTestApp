package com.podolian.network.mapper

import com.podolian.data.remote.model.*
import com.podolian.network.model.*

internal fun NetworkGenre.toRemote() = RemoteGenre(
    name = this.name
)

internal fun NetworkResult.toRemote() = RemoteItemData(
    artistName = this.artistName,
    id = this.id,
    name = this.name,
    releaseDate = this.releaseDate,
    artworkUrl100 = this.artworkUrl100,
    genres = this.genres.map { it.toRemote() },
    url = this.url
)

internal fun NetworkFeed.toRemote() = RemoteFeed(
    copyright = this.copyright,
    id = this.id,
    results = this.results.map { it.toRemote() },
)

