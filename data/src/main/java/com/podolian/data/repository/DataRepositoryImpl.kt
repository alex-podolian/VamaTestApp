package com.podolian.data.repository

import com.podolian.data.local.mapper.toDomain
import com.podolian.data.local.mapper.toLocal
import com.podolian.data.remote.mapper.toDomain
import com.podolian.domain.model.Feed
import com.podolian.domain.repository.DataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataRepositoryImpl(
    private val localSource: LocalSource,
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

    override fun retrieveData(
        mediaType: String,
        storefront: String,
        type: String,
        feed: String,
        resultLimit: Int,
        format: String
    ): Flow<Feed?> {
        return localSource.retrieveData(mediaType, storefront, type, feed, resultLimit, format)
            .map { it?.toDomain() }
    }

    override suspend fun persistData(feed: Feed) : Feed {
        localSource.persistData(feed.toLocal())
        return feed
    }
}