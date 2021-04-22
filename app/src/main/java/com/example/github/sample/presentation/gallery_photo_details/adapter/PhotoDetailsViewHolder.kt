package com.example.github.sample.presentation.gallery_photo_details.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.github.sample.R
import com.github.chrisbanes.photoview.PhotoView

class PhotoDetailsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val imagePhotoDetails: PhotoView = view.findViewById(R.id.image_view_details_image)
    val textDetails: TextView = view.findViewById(R.id.text_view_details_image)

    fun get(): Int = adapterPosition
}

