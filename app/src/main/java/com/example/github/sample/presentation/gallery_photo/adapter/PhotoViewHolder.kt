package com.example.github.sample.presentation.gallery_photo.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.github.sample.R
import com.example.github.sample.domain.entity.Photo

class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val namePhoto: TextView = view.findViewById(R.id.text_view_name_photo)
    val deletePhoto: ImageView = view.findViewById(R.id.image_view_delete)
    val renamePhoto: TextView = view.findViewById(R.id.text_view_rename)
    val imagePhoto: ImageView = view.findViewById(R.id.image_view_photo)

    fun get(): Int = adapterPosition

    fun bind(photo: Photo) {
        namePhoto.text = photo.name
    }
}
