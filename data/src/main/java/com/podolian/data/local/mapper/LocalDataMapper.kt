package com.podolian.data.local.mapper

import com.podolian.data.local.model.*
import com.podolian.domain.model.*

internal fun LocalGenre.toDomain() = Genre(
    genreId = this.genreId,
    name = this.name,
    url = this.url
)

internal fun LocalResult.toDomain() = Result(
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

internal fun LocalLink.toDomain() = Link(self = this.self)

internal fun LocalAuthor.toDomain() = Author(name = this.name, url = this.url)

internal fun LocalFeed.toDomain() = Feed(
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

internal fun Genre.toLocal() = LocalGenre(
    genreId = this.genreId,
    name = this.name,
    url = this.url
)

internal fun Result.toLocal() = LocalResult(
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

internal fun Link.toLocal() = LocalLink(self = this.self)

internal fun Author.toLocal() = LocalAuthor(name = this.name, url = this.url)

internal fun Feed.toLocal() = LocalFeed(
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

