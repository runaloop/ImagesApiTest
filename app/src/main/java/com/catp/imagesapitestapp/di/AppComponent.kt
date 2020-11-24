package com.catp.imagesapitestapp.di

import android.app.Activity
import android.app.Application
import com.catp.imagesapitestapp.App
import com.catp.imagesapitestapp.MainActivity
import com.catp.imagesapitestapp.data.di.RetrofitModule
import com.catp.imagesapitestapp.ui.home.HomeFragment
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, FragmentsModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun daggerFragmentFactory(): DaggerFragmentFactory

    fun inject(app: App)
    fun inject(activity: Activity)
    fun applyFragment(fragment: HomeFragment)
}