package com.podolian.domain.model

import java.io.Serializable

data class Feed(
    val id: String,
    val copyright: String,
    val results: List<ItemData>
) : Serializable

data class ItemData(
    val artistName: String,
    val id: String,
    val name: String,
    val releaseDate: String,
    val artworkUrl100: String,
    val genres: List<Genre>,
    val url: String?
) : Serializable

data class Genre(
    val name: String,
) : Serializable