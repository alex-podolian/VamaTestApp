package com.podolian.data.remote.mapper

import com.podolian.data.local.model.*
import com.podolian.data.remote.model.*
import com.podolian.domain.model.*

internal fun RemoteGenre.toDomain() = Genre(
    genreId = this.genreId,
    name = this.name,
    url = this.url
)

internal fun RemoteResult.toDomain() = Result(
    artistName = this.artistName,
    id = this.id,
    name = this.name,
    releaseDate = this.releaseDate,
    kind = this.kind,
    artistId = this.artistId,
    artistUrl = this.artistUrl,
    contentAdvisoryRating = this.contentAdvisoryRating,
    artworkUrl100 = this.artworkUrl100,
    genres = this.genres.map { it.toDomain() },
    url = this.url
)

internal fun RemoteLink.toDomain() = Link(self = this.self)

internal fun RemoteAuthor.toDomain() = Author(name = this.name, url = this.url)

internal fun RemoteFeed.toDomain() = Feed(
    author = this.author.toDomain(),
    copyright = this.copyright,
    country = this.country,
    icon = this.icon,
    id = this.id,
    links = this.links.map { it.toDomain() },
    results = this.results.map { it.toDomain() },
    title = this.title,
    updated = this.updated
)

internal fun RemoteGenre.toLocal() = LocalGenre(
    genreId = this.genreId,
    name = this.name,
    url = this.url
)

internal fun RemoteResult.toLocal() = LocalResult(
    artistName = this.artistName,
    id = this.id,
    name = this.name,
    releaseDate = this.releaseDate,
    kind = this.kind,
    artistId = this.artistId,
    artistUrl = this.artistUrl,
    contentAdvisoryRating = this.contentAdvisoryRating,
    artworkUrl100 = this.artworkUrl100,
    genres = this.genres.map { it.toLocal() },
    url = this.url
)

internal fun RemoteLink.toLocal() = LocalLink(self = this.self)

internal fun RemoteAuthor.toLocal() = LocalAuthor(name = this.name, url = this.url)

internal fun RemoteFeed.toLocal() = LocalFeed(
    author = this.author.toLocal(),
    copyright = this.copyright,
    country = this.country,
    icon = this.icon,
    id = this.id,
    links = this.links.map { it.toLocal() },
    results = this.results.map { it.toLocal() },
    title = this.title,
    updated = this.updated
)

