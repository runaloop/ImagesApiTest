package com.catp.imagesapitestapp.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ApplicationContextModule {
    @Singleton
    @Provides
    fun context(app: Application): Context {
        return app.applicationContext
    }
}