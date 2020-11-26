package com.catp.imagesapitestapp.data.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Photo(
    @PrimaryKey val id: String,
    val created_at: Long = 0,
    val width: Int = 0,
    val height: Int = 0,
    val urlSmall: String = "",
    val urlBig: String = "",
    var likes: Int = 0,
    var liked: Boolean = false,
    val userId: String = "",
    val userName: String = ""
)