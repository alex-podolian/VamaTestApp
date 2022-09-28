package com.podolian.data.repository

import com.podolian.data.local.model.LocalFeed
import kotlinx.coroutines.flow.Flow

interface LocalSource {
    fun retrieveData(
        mediaType: String,
        storefront: String,
        type: String,
        feed: String,
        resultLimit: Int,
        format: String
    ): Flow<LocalFeed?>

    suspend fun persistData(localFeed: LocalFeed)
}