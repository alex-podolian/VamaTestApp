package com.podolian.data.local.model

data class LocalGenre(
    val name: String
)

data class LocalItemData(
    val artistName: String,
    val id: String,
    val name: String,
    val releaseDate: String,
    val artworkUrl100: String,
    val genres: List<LocalGenre>,
    val url: String?
)

data class LocalFeed(
    val id: String,
    val copyright: String,
    val results: List<LocalItemData>
)