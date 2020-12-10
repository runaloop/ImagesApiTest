package com.catp.imagesapitestapp.data.di

import com.catp.imagesapitestapp.data.UnsplashService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter.Factory
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [OkHttpModule::class, JsonConverterModule::class, AsyncAdapterModule::class])
class RetrofitModule {
    @Singleton
    @Provides
    fun api(
        httpClient: OkHttpClient,
        @BaseUrl baseUrl: String,
        jsonFactory: Factory,
        callAdapterFactory: CallAdapter.Factory
    ): UnsplashService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(httpClient)
        .addConverterFactory(jsonFactory)
        .addCallAdapterFactory(callAdapterFactory)
        .build()
        .create(UnsplashService::class.java)

    @Provides
    @BaseUrl
    fun baseUrl() = "https://api.unsplash.com/"
}