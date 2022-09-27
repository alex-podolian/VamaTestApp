package com.podolian.network.di

import com.podolian.data.repository.RemoteSource
import com.podolian.network.NetworkSource
import com.podolian.network.services.ApiService
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://rss.applemarketingtools.com/"

val networkModule = module {
    factory { provideInterceptor() }
    factory { provideOkHttpClient(interceptor = get()) }
    factory { provideApiService(retrofit = get()) }
    single { provideRetrofit(okHttpClient = get()) }
    single { provideNetworkSource(apiService = get()) }
}

fun provideInterceptor() : Interceptor {
    return Interceptor { chain ->
        val originalRequest = chain.request()
        val originalHttpUrl: HttpUrl = originalRequest.url
        val url = originalHttpUrl.newBuilder().build()
        val requestBuilder: Request.Builder = originalRequest.newBuilder().url(url)
        val request = requestBuilder.build()
        chain.proceed(request)
    }
}

fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(interceptor = interceptor)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .cache(null)
        .build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

fun provideNetworkSource(apiService: ApiService) : RemoteSource {
    return NetworkSource(apiService)
}
