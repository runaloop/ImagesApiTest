package com.catp.imagesapitestapp.data.model

import com.catp.imagesapitestapp.data.model.api.Photo
import java.text.SimpleDateFormat

object ApiPhotoToDbPhotoConverter {
    fun convert(photo: Photo) =
        com.catp.imagesapitestapp.data.model.db.Photo(
            photo.id,
            photo.created_at,
            photo.width,
            photo.height,
            photo.urls.small,
            photo.urls.full,
            photo.likes,
            false,
            photo.user.id,
            photo.user.name
        )
}