package com.filip.zych.githubsearchapp.screens

import android.app.Activity
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ImageLoader(private val activity: Activity) {

    fun loadImage(uri: String, target: ImageView) {
        Glide.with(activity).load(uri).apply(RequestOptions().centerCrop()).into(target)
    }
}