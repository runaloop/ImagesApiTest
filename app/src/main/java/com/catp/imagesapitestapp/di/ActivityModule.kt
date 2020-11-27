package com.catp.imagesapitestapp.di

import android.content.res.Configuration
import android.content.res.Resources
import com.catp.imagesapitestapp.MainActivity
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ActivityModule(val activity: MainActivity) {
    @Provides
    fun resources(): Resources {
        return activity.resources
    }
}