package com.catp.imagesapitestapp.di

import com.catp.imagesapitestapp.data.model.db.Photo
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.disposables.CompositeDisposable


@Module
class UtilModule() {
    @Provides
    fun compositeDisposable() = CompositeDisposable()

    @Provides
    fun mutableListOfPhotos() = mutableListOf<Photo>()
}