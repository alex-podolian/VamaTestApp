package com.podolian.domain.repository

import com.podolian.domain.model.Feed
import kotlinx.coroutines.flow.Flow

interface DataRepository {
    suspend fun fetchData(
        mediaType: String,
        storefront: String,
        type: String,
        feed: String,
        resultLimit: Int,
        format: String
    ): Feed

    fun retrieveData(
        mediaType: String,
        storefront: String,
        type: String,
        feed: String,
        resultLimit: Int,
        format: String
    ): Flow<Feed?>

    suspend fun persistData(feed: Feed) : Feed
}