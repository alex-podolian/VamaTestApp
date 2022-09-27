package com.podolian.data.repository

import com.podolian.data.remote.mapper.toDomain
import com.podolian.domain.model.Feed
import com.podolian.domain.repository.DataRepository

class DataRepositoryImpl(
    private val remoteSource: RemoteSource
) : DataRepository {

    override suspend fun fetchData(
        mediaType: String,
        storefront: String,
        type: String,
        feed: String,
        resultLimit: Int,
        format: String
    ): Feed = remoteSource.fetchFeed(
        mediaType = mediaType,
        storefront = storefront,
        type = type,
        feed = feed,
        resultLimit = resultLimit,
        format = format
    ).toDomain()
}