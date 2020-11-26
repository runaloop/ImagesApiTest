package com.catp.imagesapitestapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.catp.imagesapitestapp.data.model.db.Photo

@Database(entities = [Photo::class], version = 1)
abstract class DB : RoomDatabase() {
    abstract fun userDao(): Dao
}