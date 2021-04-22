package com.example.github.sample.presentation.gallery_photo.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.github.sample.domain.entity.Photo

class PhotoDiffCallback : DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }
}
