package com.catp.imagesapitestapp.ui.home

import com.catp.imagesapitestapp.data.model.db.Photo
import javax.inject.Inject


class OnLikeClickListener @Inject constructor(private val viewModel: HomeViewModel) {
    fun onClick(photo: Photo) {
        viewModel.onLikeClick(photo)
    }
}