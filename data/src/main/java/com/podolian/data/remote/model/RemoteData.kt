package com.podolian.data.remote.model

data class RemoteGenre(
    val name: String
)

data class RemoteItemData(
    val artistName: String,
    val id: String,
    val name: String,
    val releaseDate: String,
    val artworkUrl100: String,
    val genres: List<RemoteGenre>,
    val url: String?
)

data class RemoteFeed(
    val id: String,
    val copyright: String,
    val results: List<RemoteItemData>
)