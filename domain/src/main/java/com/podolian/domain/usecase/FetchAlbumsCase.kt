package com.podolian.domain.usecase

import com.podolian.domain.model.Feed
import com.podolian.domain.model.RequestParams
import com.podolian.domain.repository.DataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface FetchAlbumsCase {
    suspend operator fun invoke(requestParams: RequestParams): Flow<Feed>
}

class FetchAlbumsCaseImpl(private val dataRepository: DataRepository) : FetchAlbumsCase {
    override suspend fun invoke(requestParams: RequestParams): Flow<Feed> = flow {
        emit(dataRepository.fetchData(
            mediaType = requestParams.mediaType,
            storefront = requestParams.storefront,
            type = requestParams.type,
            feed = requestParams.feed,
            resultLimit = requestParams.resultLimit,
            format = requestParams.format
        ))
    }
}