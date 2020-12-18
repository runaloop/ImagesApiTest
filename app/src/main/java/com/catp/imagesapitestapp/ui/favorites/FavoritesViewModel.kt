package com.catp.imagesapitestapp.ui.favorites

import androidx.lifecycle.MutableLiveData
import com.catp.imagesapitestapp.data.Repo
import com.catp.imagesapitestapp.data.model.db.Photo
import com.catp.imagesapitestapp.ui.base.BaseListViewModel
import com.catp.imagesapitestapp.util.SingleLiveEvent
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class FavoritesViewModel @Inject constructor(
    repo: Repo,
    cs: CompositeDisposable,
    errorTextLiveData: SingleLiveEvent<String>,
    loadingState: MutableLiveData<Boolean>,
    items: MutableLiveData<List<Photo>>,
    navigateToDetailScreen: MutableLiveData<Photo?>
) : BaseListViewModel(repo, cs, errorTextLiveData, loadingState, items, navigateToDetailScreen) {
    override fun getPhotosObservable(): Observable<List<Photo>> = repo.getFavoritesPhotos()
}