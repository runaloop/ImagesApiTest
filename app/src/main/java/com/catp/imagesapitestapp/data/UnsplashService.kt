package com.catp.imagesapitestapp.data

import com.catp.imagesapitestapp.BuildConfig
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface UnsplashService {
    @Headers("Authorization: Client-ID ${BuildConfig.ACCESS_KEY}")
    @GET("photos")
    fun listPhotos(): Observable<List<Photo>>
}
