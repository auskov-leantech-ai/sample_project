package com.example.github.sample.presentation.gallery_photo_details.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.github.sample.domain.entity.Image

class ImageDiffCallback : DiffUtil.ItemCallback<Image>() {
    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.image == newItem.image
    }

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem
    }
}
