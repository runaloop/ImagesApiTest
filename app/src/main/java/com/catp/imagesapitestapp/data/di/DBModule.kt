package com.catp.imagesapitestapp.data.di

import android.content.Context
import androidx.room.Room
import com.catp.imagesapitestapp.data.DB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule {
    @Singleton
    @Provides
    fun db(applicationContext: Context) = Room.databaseBuilder(
        applicationContext,
        DB::class.java, "database-name"
    ).build()

    @Singleton
    @Provides
    fun dao(db: DB) = db.photoDao()
}