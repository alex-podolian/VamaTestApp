package com.podolian.data.local.model

data class LocalFeed(
    val title: String,
    val id: String,
    val author: LocalAuthor,
    val links: List<LocalLink>,
    val copyright: String,
    val country: String,
    val icon: String,
    val updated: String,
    val results: List<LocalResult>
)

data class LocalAuthor(
    val name: String,
    val url: String
)

data class LocalLink(
    val self: String
)

data class LocalResult(
    val artistName: String,
    val id: String,
    val name: String,
    val releaseDate: String,
    val kind: String,
    val artistId: String?,
    val artistUrl: String?,
    val contentAdvisoryRating: String?,
    val artworkUrl100: String,
    val genres: List<LocalGenre>,
    val url: String
)

data class LocalGenre(
    val genreId: String,
    val name: String,
    val url: String
)