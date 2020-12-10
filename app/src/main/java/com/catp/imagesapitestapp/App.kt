package com.catp.imagesapitestapp

import android.app.Application
import com.catp.imagesapitestapp.di.Injector

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.init(this)
    }
}
