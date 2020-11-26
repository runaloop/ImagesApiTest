package com.catp.imagesapitestapp.ui.favorites

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

class FavoritesViewModel @Inject constructor(
    private val repo: Repo,
    private val cs: CompositeDisposable
) : ViewModel() {

    private val _errorText = SingleLiveEvent<String>()
    val errorText = _errorText as LiveData<String>

    private val _loading = MutableLiveData<Boolean>().apply {
        true
    }
    val loading: LiveData<Boolean> = _loading

    private val _items = MutableLiveData<List<Photo>>()
    val items: LiveData<List<Photo>> = _items

    init {
        repo.getFavoritesPhotos()
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
}