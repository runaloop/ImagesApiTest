package com.catp.imagesapitestapp.di

import android.app.Activity
import android.app.Application
import com.catp.imagesapitestapp.App
import com.catp.imagesapitestapp.data.di.DBModule
import com.catp.imagesapitestapp.data.di.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, FragmentsModule::class, UtilModule::class, ApplicationContextModule::class, DBModule::class])
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
}