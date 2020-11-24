package com.catp.imagesapitestapp.di

import androidx.fragment.app.Fragment
import com.catp.imagesapitestapp.ui.home.HomeFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentsModule {

    @Binds
    @IntoMap
    @FragmentKey(HomeFragment::class)
    abstract fun homeFragment(fragment: HomeFragment): Fragment
}