package com.podolian.data.remote.model

data class RemoteGenre(
    val genreId: String,
    val name: String,
    val url: String
)

data class RemoteResult(
    val artistName: String,
    val id: String,
    val name: String,
    val releaseDate: String,
    val kind: String,
    val artistId: String?,
    val artistUrl: String?,
    val contentAdvisoryRating: String?,
    val artworkUrl100: String,
    val genres: List<RemoteGenre>,
    val url: String
)

data class RemoteLink(
    val self: String
)

data class RemoteAuthor(
    val name: String,
    val url: String
)

data class RemoteFeed(
    val title: String,
    val id: String,
    val author: RemoteAuthor,
    val links: List<RemoteLink>,
    val copyright: String,
    val country: String,
    val icon: String,
    val updated: String,
    val results: List<RemoteResult>
)