package com.catp.imagesapitestapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.catp.imagesapitestapp.data.Repo
import com.catp.imagesapitestapp.data.model.db.Photo
import com.catp.imagesapitestapp.util.SingleLiveEvent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repo: Repo,
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

    //TODO: Насколько правильно обновлять состояние ошибки из двух несвязанных мест?
    init {
        repo.requestRecentPhotos()
            .doOnError {
                _errorText.value = "Network error ${it.message}"
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
            .addTo(cs)

        repo.getRecentPhotos()
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

    fun refreshList() {
        repo.requestRecentPhotos()
            .doOnError {
                _errorText.value = "Network error ${it.message}"
            }
            .subscribe()
            .addTo(cs)
    }

    fun loadMore() {
        repo.requestRecentPhotos()
            .doOnError {
                _errorText.value = "Network error ${it.message}"
            }
            .subscribe()
            .addTo(cs)
    }

    override fun onCleared() {
        cs.clear()
        super.onCleared()
    }
}