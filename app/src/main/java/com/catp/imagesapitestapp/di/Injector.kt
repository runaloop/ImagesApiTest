package com.catp.imagesapitestapp.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.catp.imagesapitestapp.App
//    android:paddingTop="?attr/actionBarSize" как быстро находить подобные косяки?
/**
 * Вот где храняться эти мульти биндинги?
 * Нужно ли мультибиндинг скоупить? или оно автоматом скопится? к текущему компонент скоупу?
 * Если FragmentsModule понятно они прям в нем, то вот для ViewModel как? в стандартном хранилище ViewModelStore и если там нет то создаеться? а где этот код? который чекает наличие в ViewModelStore
 * Если в модуле есть констуктор то как в компоненте прокинуть параметр этого конструктора?
 * Если есть зависимые компоненты зачем нужны сабкомпонентс?
 * Можно ли в синглтоне сохранять ссылку на appComponent в ActivityLifecycleCallbacks
 * Зачем нужна MustBeDocumented в FragmentKey
 * Получается дагер сразу генерит 2 типа зависимостей - первый это простая зависимость, вторая это провайдеры, и одновременно можно оба использовать?
 * JvmSuppressWildcards зачем нуен
 * Нужно ли инжектить LiveData/MutableLiveData в ViewModel?
 */
object Injector {
    fun init(app: App) {
        val appComponent = DaggerAppComponent.builder().application(app)
            .build()
        appComponent.inject(app)
        app
            .registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                    appComponent.inject(activity)
                    (activity as FragmentActivity).supportFragmentManager.fragmentFactory = appComponent.daggerFragmentFactory()
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