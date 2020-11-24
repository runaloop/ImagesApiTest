package com.catp.imagesapitestapp.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ContextModule(private val app: Application) {
    @Singleton
    @Provides
    fun context(): Context {
        return app.applicationContext
    }
}