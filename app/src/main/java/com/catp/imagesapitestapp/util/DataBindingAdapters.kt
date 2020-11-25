package com.catp.imagesapitestapp.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setImage")
fun setImage(view: ImageView, imgPath: String) {
    Glide.with(view).load(imgPath).into(view)
}