package com.catp.imagesapitestapp.data

import com.catp.imagesapitestapp.BuildConfig
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface UnsplashService {
    @Headers("Authorization: Client-ID ${BuildConfig.ACCESS_KEY}")
    @GET("photos")
    fun listPhotos(): Single<List<Photo>>
}
