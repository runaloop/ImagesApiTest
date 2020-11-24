package com.catp.imagesapitestapp.di

import androidx.fragment.app.Fragment
import com.catp.imagesapitestapp.ui.dashboard.DashboardFragment
import com.catp.imagesapitestapp.ui.home.HomeFragment
import com.catp.imagesapitestapp.ui.notifications.NotificationsFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentsModule {

    @Binds
    @IntoMap
    @FragmentKey(HomeFragment::class)
    abstract fun homeFragment(fragment: HomeFragment): Fragment
    @Binds
    @IntoMap
    @FragmentKey(DashboardFragment::class)
    abstract fun dashboardFragment(fragment: DashboardFragment): Fragment
    @Binds
    @IntoMap
    @FragmentKey(NotificationsFragment::class)
    abstract fun notificationsFragment(fragment: NotificationsFragment): Fragment

}