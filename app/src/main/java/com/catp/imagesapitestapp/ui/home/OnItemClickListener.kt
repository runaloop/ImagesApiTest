package com.catp.imagesapitestapp.ui.home

import com.catp.imagesapitestapp.data.model.db.Photo
import javax.inject.Inject


class OnItemClickListener @Inject constructor(private val viewModel: HomeViewModel) {
    fun onClick(photo: Photo) {
        viewModel.onLikeClick(photo)
    }
}