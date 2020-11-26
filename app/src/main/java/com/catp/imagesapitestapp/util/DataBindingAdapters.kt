package com.catp.imagesapitestapp.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setImage")
fun setImage(view: ImageView, imgPath: String) {
    Glide.with(view).load(imgPath).into(view)
}

@BindingAdapter("setFavorite", "favoriteIcon", "notFavoriteIcon")
fun setFavorite(
    view: ImageView,
    isFavorite: Boolean,
    favoriteIcon: Drawable,
    notFavoriteIcon: Drawable
) {
    view.setImageDrawable(if (isFavorite) favoriteIcon else notFavoriteIcon)
}

@BindingAdapter("likesCount")
fun likesCount(view: TextView, likesCount: Int) {
    view.text = likesCount.toString()
}

