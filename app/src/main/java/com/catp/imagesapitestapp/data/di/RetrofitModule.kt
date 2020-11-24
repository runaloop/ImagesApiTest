package com.catp.imagesapitestapp.data.di

import com.catp.imagesapitestapp.data.UnsplashService
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [OkHttpModule::class, JsonConverterModule::class, AsyncAdapterModule::class])
class RetrofitModule {
    @Singleton
    @Provides
    fun api(
        httpClient: OkHttpClient,
        @Named("BASE_URL") baseUrl: String,
        jsonFactory: Converter.Factory,
        callAdapterFactory: CallAdapter.Factory
        ) = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(httpClient)
        .addConverterFactory(jsonFactory)
        .addCallAdapterFactory(callAdapterFactory)
        .build()
        .create(UnsplashService::class.java)

    @Provides
    @Named("BASE_URL")
    fun baseUrl() = "https://api.unsplash.com/"
}