package com.podolian.domain.usecase

import com.podolian.domain.model.Feed
import com.podolian.domain.model.RequestParams
import com.podolian.domain.repository.DataRepository
import kotlinx.coroutines.flow.Flow

interface RetrievePersistedDataCase {
    operator fun invoke(requestParams: RequestParams): Flow<Feed?>
}

class RetrievePersistedDataCaseImpl(private val dataRepository: DataRepository) :
    RetrievePersistedDataCase {
    override fun invoke(requestParams: RequestParams): Flow<Feed?> =
        dataRepository.retrieveData(
            mediaType = requestParams.mediaType,
            storefront = requestParams.storefront,
            type = requestParams.type,
            feed = requestParams.feed,
            resultLimit = requestParams.resultLimit,
            format = requestParams.format
        )
}