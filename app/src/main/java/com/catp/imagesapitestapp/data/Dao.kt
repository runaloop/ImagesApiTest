package com.catp.imagesapitestapp.data

import androidx.room.*
import androidx.room.Dao
import com.catp.imagesapitestapp.data.model.db.Photo

@Dao
interface Dao {
    @Query("SELECT * FROM Photo")
    fun getAll(): List<Photo>

    @Query("SELECT * FROM Photo WHERE liked==1")
    fun getLiked(): List<Photo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updatePhoto(photo: Photo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(photos: List<Photo>)

    @Delete
    fun deletePhoto(photo: Photo)
}