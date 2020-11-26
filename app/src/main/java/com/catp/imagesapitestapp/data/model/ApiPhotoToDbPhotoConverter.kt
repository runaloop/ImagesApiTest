package com.catp.imagesapitestapp.data.model

import com.catp.imagesapitestapp.data.model.api.Photo
import java.text.SimpleDateFormat

object ApiPhotoToDbPhotoConverter {
    fun convert(photo: Photo) =
        com.catp.imagesapitestapp.data.model.db.Photo(
            photo.id,
            stringDateToLong(photo.created_at),
            photo.width,
            photo.height,
            photo.urls.small,
            photo.urls.full,
            photo.likes,
            false,
            photo.user.id,
            photo.user.name
        )

    private fun stringDateToLong(str: String): Long {
        val date = sdf.parse(str)
        return date.time
    }
    private val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX")
}