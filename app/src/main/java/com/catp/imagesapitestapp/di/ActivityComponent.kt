package com.catp.imagesapitestapp.di

import android.app.Activity
import dagger.Subcomponent

@Subcomponent(modules = [ActivityModule::class, FragmentsModule::class])
interface ActivityComponent {
    fun inject(activity: Activity)
    fun daggerFragmentFactory(): DaggerFragmentFactory

}