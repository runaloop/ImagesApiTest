package com.catp.imagesapitestapp.di

import androidx.lifecycle.MutableLiveData
import com.catp.imagesapitestapp.data.model.db.Photo
import com.catp.imagesapitestapp.util.SingleLiveEvent
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.disposables.CompositeDisposable


@Module
class UtilModule() {
    @Provides
    fun singleStringLiveEvent() = SingleLiveEvent<String>()

    @Provides
    fun mutableBooleanLiveData() = MutableLiveData<Boolean>()
    @Provides
    fun mutablePhotoListLiveData() = MutableLiveData<List<Photo>>()

    @Provides
    fun compositeDisposable() = CompositeDisposable()

    @Provides
    fun mutableListOfPhotos() = mutableListOf<Photo>()
}