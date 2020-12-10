package com.catp.imagesapitestapp.ui.base

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

open class BaseListViewModel @Inject constructor(
    protected val repo: Repo,
    private val cs: CompositeDisposable,
    private val _errorText: SingleLiveEvent<String>,
    private val _loading: MutableLiveData<Boolean>,
    private val _items: MutableLiveData<List<Photo>>
) : ViewModel() {

    val errorText = _errorText as LiveData<String>
    val loading: LiveData<Boolean> = _loading
    val items: LiveData<List<Photo>> = _items

    init {
        //TODO: Насколько правильно обновлять состояние ошибки из двух несвязанных мест?
        refreshList()
        observePhotos()
    }

    open fun getPhotosObservable() = repo.getRecentPhotos()
    private fun observePhotos() {

        getPhotosObservable()
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
            .observeOn(AndroidSchedulers.mainThread())
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

    fun onLikeClick(photo: Photo) {
        if (photo.liked) {
            photo.liked = false
            photo.likes--
        } else {
            photo.liked = true
            photo.likes++
        }
        repo.updatePhoto(photo)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            }, {
                _errorText.value = "Can't update: ${it.message}"
            })
            .addTo(cs)
    }
}