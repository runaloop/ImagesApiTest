package com.catp.imagesapitestapp.data.di

import com.catp.imagesapitestapp.di.ContextModule
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
class OkHttpModule {
    @Singleton
    @Provides
    fun httpClient(interceptor: HttpLoggingInterceptor) =
        OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()

    @Singleton
    @Provides
    fun logginInterceptor() = HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) }
}