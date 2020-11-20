package com.catp.imagesapitestapp.data

import com.catp.imagesapitestapp.BuildConfig
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface UnsplashService {
    @Headers("Authorization: Client-ID ${BuildConfig.ACCESS_KEY}")
    @GET("photos")
    fun listPhotos(): Observable<Photos>
}

object UnsplashServiceAPI{

}