package com.example.movieapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.movieapp.adapter.IMAGE_BACKDROP_PATH

class ImageUtils {

    companion object {
        @JvmStatic
        @BindingAdapter("poster_path")
        fun loadImage(view: ImageView, poster_path: String) {
            Glide.with(view.context)
                .load(IMAGE_BACKDROP_PATH + poster_path)
                .into(view)
        }
    }
}