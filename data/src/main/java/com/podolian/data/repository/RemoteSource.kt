package com.podolian.data.repository

import com.podolian.data.remote.model.RemoteFeed

interface RemoteSource {

    suspend fun fetchFeed(
        mediaType: String,
        storefront: String,
        type: String,
        feed: String,
        resultLimit: Int,
        format: String
    ): RemoteFeed
}