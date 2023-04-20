package com.mobsky.recipechat.presentation.view

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.loadImageUrl(url: String){
    Glide
        .with(context)
        .load(url)
        .centerCrop()
//        .placeholder(R.drawable.loading_spinner)
        .into(this)
}