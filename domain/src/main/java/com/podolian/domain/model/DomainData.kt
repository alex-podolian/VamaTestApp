package com.podolian.domain.model

import java.io.Serializable

data class Feed(
    val title: String,
    val id: String,
    val author: Author,
    val links: List<Link>,
    val copyright: String,
    val country: String,
    val icon: String,
    val updated: String,
    val results: List<ItemData>
) : Serializable

data class Author(
    val name: String,
    val url: String
) : Serializable

data class Link(
    val self: String
) : Serializable

data class ItemData(
    val artistName: String,
    val id: String,
    val name: String,
    val releaseDate: String,
    val kind: String,
    val artistId: String?,
    val artistUrl: String?,
    val contentAdvisoryRating: String?,
    val artworkUrl100: String,
    val genres: List<Genre>,
    val url: String
) : Serializable

data class Genre(
    val genreId: String,
    val name: String,
    val url: String
) : Serializable