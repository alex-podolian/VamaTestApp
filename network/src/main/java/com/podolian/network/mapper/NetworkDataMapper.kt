package com.podolian.network.mapper

import com.podolian.data.remote.model.*
import com.podolian.network.model.*

internal fun NetworkGenre.toRemote() = RemoteGenre(
    genreId = this.genreId,
    name = this.name,
    url = this.url
)

internal fun NetworkResult.toRemote() = RemoteItemData(
    artistName = this.artistName,
    id = this.id,
    name = this.name,
    releaseDate = this.releaseDate,
    kind = this.kind,
    artistId = this.artistId,
    artistUrl = this.artistUrl,
    contentAdvisoryRating = this.contentAdvisoryRating,
    artworkUrl100 = this.artworkUrl100,
    genres = this.genres.map { it.toRemote() },
    url = this.url
)

internal fun NetworkLink.toRemote() = RemoteLink(self = this.self)

internal fun NetworkAuthor.toRemote() = RemoteAuthor(name = this.name, url = this.url)

internal fun NetworkFeed.toRemote() = RemoteFeed(
    author = this.author.toRemote(),
    copyright = this.copyright,
    country = this.country,
    icon = this.icon,
    id = this.id,
    links = this.links.map { it.toRemote() },
    results = this.results.map { it.toRemote() },
    title = this.title,
    updated = this.updated
)

