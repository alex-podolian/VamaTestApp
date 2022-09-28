package com.podolian.database

import com.podolian.data.local.model.LocalFeed
import com.podolian.data.repository.LocalSource
import com.podolian.database.mapper.toDatabase
import com.podolian.database.mapper.toLocal
import com.podolian.database.model.PersistedFeed
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.ext.toRealmList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class DatabaseSource(
    private val realm: Realm,
) : LocalSource {

    override fun retrieveData(
        mediaType: String,
        storefront: String,
        type: String,
        feed: String,
        resultLimit: Int,
        format: String
    ): Flow<LocalFeed?> {
        return realm.query(
            PersistedFeed::class,
            "id CONTAINS '$mediaType' " +
                    "AND id CONTAINS '$storefront' " +
                    "AND id CONTAINS '$type' " +
                    "AND id CONTAINS '$feed' " +
                    "AND id CONTAINS '$resultLimit' " +
                    "AND id CONTAINS '$format'"
        )
            .first()
            .asFlow()
            .flowOn(Dispatchers.IO)
            .map { it.obj?.toLocal() }
    }

    override suspend fun persistData(localFeed: LocalFeed) {
        withContext(Dispatchers.IO) {
            realm.write {
                val persistedFeed: PersistedFeed? =
                    this.query<PersistedFeed>("id = '${localFeed.id}'").first().find()
                if (persistedFeed != null) {
                    persistedFeed.copyright = localFeed.copyright
                    persistedFeed.results = localFeed.results.map { it.toDatabase() }.toRealmList()
                } else {
                    copyToRealm(localFeed.toDatabase())
                }
            }
        }
    }
}