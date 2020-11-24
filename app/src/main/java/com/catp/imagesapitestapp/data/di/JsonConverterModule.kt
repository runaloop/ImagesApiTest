package com.catp.imagesapitestapp.data.di

import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

@Module
class JsonConverterModule {
    @Provides
    fun json(): Converter.Factory = GsonConverterFactory.create()
}