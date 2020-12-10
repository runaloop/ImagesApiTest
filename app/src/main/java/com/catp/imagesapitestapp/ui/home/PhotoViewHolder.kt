package com.catp.imagesapitestapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.catp.imagesapitestapp.data.model.db.Photo
import com.catp.imagesapitestapp.databinding.PhotoItemBinding

class PhotoViewHolder(val itemBinding: PhotoItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(photo: Photo) {
        itemBinding.photo = photo
    }
}