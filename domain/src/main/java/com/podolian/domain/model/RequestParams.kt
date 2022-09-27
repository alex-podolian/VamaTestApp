package com.podolian.domain.model

data class RequestParams(
    val mediaType: String = "music",
    val storefront: String = "us",
    val type: String = "albums",
    val feed: String = "most-played",
    val resultLimit: Int = 100,
    val format: String = "json",
)