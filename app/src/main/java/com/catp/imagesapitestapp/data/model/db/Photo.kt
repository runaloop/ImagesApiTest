package com.catp.imagesapitestapp.data.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Photo(
    @PrimaryKey val id: String,
    val created_at: String = "",
    val width: Int = 0,
    val height: Int = 0,
    val urlSmall: String = "",
    val urlBig: String = "",
    val likes: Int = 0,
    val liked: Boolean = false,
    val userId: String = "",
    val userName: String = ""
)