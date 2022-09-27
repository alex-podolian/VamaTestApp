package com.podolian.network.model

data class NetworkGenre(
    val genreId: String,
    val name: String,
    val url: String
)

data class NetworkLink(
    val self: String
)

data class NetworkResult(
    val artistName: String,
    val id: String,
    val name: String,
    val releaseDate: String,
    val kind: String,
    val artistId: String?,
    val artistUrl: String?,
    val contentAdvisoryRating: String?,
    val artworkUrl100: String,
    val genres: List<NetworkGenre>,
    val url: String
)

data class NetworkAuthor(
    val name: String,
    val url: String
)

data class NetworkFeed(
    val title: String,
    val id: String,
    val author: NetworkAuthor,
    val links: List<NetworkLink>,
    val copyright: String,
    val country: String,
    val icon: String,
    val updated: String,
    val results: List<NetworkResult>
)

data class NetData(
    val feed: NetworkFeed
)
