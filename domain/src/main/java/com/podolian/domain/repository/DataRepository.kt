package com.podolian.domain.repository

import com.podolian.domain.model.Feed

interface DataRepository {
    suspend fun fetchData(
        mediaType: String,
        storefront: String,
        type: String,
        feed: String,
        resultLimit: Int,
        format: String
    ): Feed
}