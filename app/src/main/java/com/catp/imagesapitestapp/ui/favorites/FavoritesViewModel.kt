package com.catp.imagesapitestapp.ui.favorites

import com.catp.imagesapitestapp.data.Repo
import com.catp.imagesapitestapp.data.model.db.Photo
import com.catp.imagesapitestapp.ui.base.BaseListViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class FavoritesViewModel @Inject constructor(
    repo: Repo,
    cs: CompositeDisposable
) : BaseListViewModel(repo, cs) {
    override fun getPhotosObservable(): Observable<List<Photo>> = repo.getFavoritesPhotos()
}