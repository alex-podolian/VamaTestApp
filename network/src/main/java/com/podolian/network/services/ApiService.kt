package com.podolian.network.services

import com.podolian.network.model.NetData
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/v2/{storefront}/{mediaType}/{feed}/{resultLimit}/{type}.{format}")
    suspend fun fetchData(
        @Path("mediaType") mediaType: String,
        @Path("storefront") storefront: String,
        @Path("type") type: String,
        @Path("feed") feed: String,
        @Path("resultLimit") resultLimit: Int,
        @Path("format") format: String
    ): NetData
}