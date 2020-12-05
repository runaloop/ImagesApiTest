package com.catp.imagesapitestapp.di

import android.app.Application
import androidx.fragment.app.Fragment
import com.catp.imagesapitestapp.App
import com.catp.imagesapitestapp.Cat
import com.catp.imagesapitestapp.Pet
import com.catp.imagesapitestapp.PetModule
import com.catp.imagesapitestapp.data.di.DBModule
import com.catp.imagesapitestapp.data.di.RetrofitModule
import com.catp.imagesapitestapp.ui.home.HomeFragment
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, UtilModule::class, ApplicationContextModule::class, DBModule::class, PetModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun plus(module: ActivityModule): ActivityComponent
    fun inject(app: App)
}