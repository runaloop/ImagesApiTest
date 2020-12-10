package com.catp.imagesapitestapp.di

import android.content.res.Resources
import com.catp.imagesapitestapp.MainActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: MainActivity) {
    @Provides
    fun resources(): Resources {
        return activity.resources
    }
}