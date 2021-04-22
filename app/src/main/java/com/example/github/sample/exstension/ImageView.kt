package com.example.github.sample.exstension

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.RequestBuilder
import com.example.github.sample.util.GlideApp.with

fun ImageView.loadImage(
    url: String?,
    customize: (RequestBuilder<Drawable>.() -> RequestBuilder<Drawable>)? = null
) =
    with(context)
        .load(url)
        .also { glideRequest ->
            if (customize != null) {
                glideRequest.customize()
            }
        }
        .into(this)
