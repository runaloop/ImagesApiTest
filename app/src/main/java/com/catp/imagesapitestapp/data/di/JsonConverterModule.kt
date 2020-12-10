package com.catp.imagesapitestapp.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

@Module
class JsonConverterModule {
    @Provides
    fun gsonProvider(): Gson {
        return GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX")
            .create()
    }

    @Provides
    fun json(gson: Gson): Converter.Factory = GsonConverterFactory.create(gson)
}