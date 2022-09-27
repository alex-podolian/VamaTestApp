package com.podolian.network

import com.podolian.data.remote.model.RemoteFeed
import com.podolian.data.repository.RemoteSource
import com.podolian.network.mapper.toRemote
import com.podolian.network.services.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NetworkSource(
    private val apiService: ApiService,
) : RemoteSource {

    override suspend fun fetchFeed(
        mediaType: String,
        storefront: String,
        type: String,
        feed: String,
        resultLimit: Int,
        format: String
    ): RemoteFeed {
        return withContext(Dispatchers.IO) {
            apiService.fetchData(
                mediaType = mediaType,
                storefront = storefront,
                type = type,
                feed = feed,
                resultLimit = resultLimit,
                format = format
            ).feed.toRemote()
        }
    }
}