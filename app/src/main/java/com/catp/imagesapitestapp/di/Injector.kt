package com.catp.imagesapitestapp.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.catp.imagesapitestapp.App
import com.catp.imagesapitestapp.MainActivity

//TODO: android:backgroundTint="#0fff" пока этого не было, цвет бекграунда иконки был серым, как выяснить кто его так покрасил?
//TODO: ApiPhotoToDbPhotoConverter наверняка ведь есть более человеческий способ это заколбаисть?
//TODO:    android:paddingTop="?attr/actionBarSize" как быстро находить подобные косяки?
//TODO: Нужно ли мультибиндинг скоупить? или оно автоматом скопится? к текущему компонент скоупу?
//TODO: Если FragmentsModule понятно они прям в нем, то вот для ViewModel как? в стандартном хранилище ViewModelStore и если там нет то создаеться? а где этот код? который чекает наличие в ViewModelStore
//TODO: Если есть зависимые компоненты зачем нужны сабкомпонентс?
//TODO: Зачем нужна MustBeDocumented в FragmentKey
//TODO: Если в модуле AppComponent сидит DaggerFragmetnFactory, то получив оттуда Provider для фрагмента, при вызове get, все его зависимости будут удовлетворены в рамках того компонента в котором живет модуль!?!? О_о
object Injector {
    fun init(app: App) {
        val appComponent = DaggerAppComponent.builder().application(app)
            .build()
        appComponent.inject(app)
        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                val activityComponent = appComponent
                    .plus(ActivityModule(activity as MainActivity))

                activityComponent.inject(activity)
                (activity as FragmentActivity).supportFragmentManager.fragmentFactory =
                    activityComponent.daggerFragmentFactory()
            }

            override fun onActivityStarted(activity: Activity) {

            }

            override fun onActivityResumed(activity: Activity) {

            }

            override fun onActivityPaused(activity: Activity) {

            }

            override fun onActivityStopped(activity: Activity) {

            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

            }

            override fun onActivityDestroyed(activity: Activity) {

            }
        })
    }
}