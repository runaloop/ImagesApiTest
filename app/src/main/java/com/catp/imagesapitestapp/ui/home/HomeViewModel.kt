package com.catp.imagesapitestapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.catp.imagesapitestapp.data.Photo
import com.catp.imagesapitestapp.data.UnsplashService
import com.catp.imagesapitestapp.util.SingleLiveEvent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val api: UnsplashService,
    private val cs: CompositeDisposable
) :
    ViewModel() {


    private val _errorText = SingleLiveEvent<String>()
    val errorText = _errorText as LiveData<String>

    private val _loading = MutableLiveData<Boolean>().apply {
        true
    }
    val loading: LiveData<Boolean> = _loading

    private val _items = MutableLiveData<List<Photo>>()
    val items: LiveData<List<Photo>> = _items


    init {
        api.listPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                _loading.value = true
            }
            .doOnError {
                _loading.value = false
                _errorText.value = "Error ${it.message}"
            }
            .subscribe { newValues ->
                _items.value = newValues
            }
            .addTo(cs)

    }

    override fun onCleared() {
        cs.clear()
        super.onCleared()
    }
}