package com.catp.imagesapitestapp.data

import com.catp.imagesapitestapp.data.model.ApiPhotoToDbPhotoConverter
import com.catp.imagesapitestapp.data.model.db.Photo
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repo @Inject constructor(private val api: UnsplashService, private val photoDao: Dao) {
    fun requestRecentPhotos(): Completable = Completable.fromObservable<Boolean> { observer ->
        api.listPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .doOnError {
                observer.onNext(false)
                observer.onError(it)
            }
            .map { list ->
                list.map { ApiPhotoToDbPhotoConverter.convert(it) }
            }
            .subscribe { result ->
                photoDao.insertAll(result)
                observer.onNext(true)
                observer.onComplete()
            }
    }


    fun getRecentPhotos(): Observable<List<Photo>> {
        return photoDao.getAll().subscribeOn(Schedulers.io())
    }

    fun getFavoritesPhotos(): Observable<List<Photo>> {
        return photoDao.getLiked().subscribeOn(Schedulers.io())
    }

    fun updatePhoto(photo: Photo): Single<Long> =
        Single
            .fromCallable {
                val result = photoDao.updatePhoto(photo)
                if (result != -1L)
                    throw IOException("Cant update photo: $photo")
                else
                    result
            }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
}