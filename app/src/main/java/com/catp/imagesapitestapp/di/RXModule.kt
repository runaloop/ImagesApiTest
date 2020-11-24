package com.catp.imagesapitestapp.di

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.disposables.CompositeDisposable


@Module
class RXModule() {
    @Provides
    fun compositeDisposable() = CompositeDisposable()
}