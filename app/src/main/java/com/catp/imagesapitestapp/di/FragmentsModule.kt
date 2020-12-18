package com.catp.imagesapitestapp.di

import androidx.fragment.app.Fragment
import com.catp.imagesapitestapp.ui.detail.DetailFragment
import com.catp.imagesapitestapp.ui.favorites.FavoritesFragment
import com.catp.imagesapitestapp.ui.home.HomeFragment
import com.catp.imagesapitestapp.ui.settings.SettingsFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentsModule {

    @Binds
    @IntoMap
    @FragmentKey(DetailFragment::class)
    abstract fun detailFragment(fragment: DetailFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(HomeFragment::class)
    abstract fun homeFragment(fragment: HomeFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(FavoritesFragment::class)
    abstract fun dashboardFragment(fragment: FavoritesFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(SettingsFragment::class)
    abstract fun notificationsFragment(fragment: SettingsFragment): Fragment

}