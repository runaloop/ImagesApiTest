package com.catp.imagesapitestapp.data.di

import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.CallAdapter

@Module
class AsyncAdapterModule {
    @Provides
    fun callAdapter(): CallAdapter.Factory = RxJava3CallAdapterFactory.create()
}