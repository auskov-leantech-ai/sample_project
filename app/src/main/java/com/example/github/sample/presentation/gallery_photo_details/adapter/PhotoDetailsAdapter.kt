package com.example.github.sample.presentation.gallery_photo_details.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.github.sample.R
import com.example.github.sample.domain.entity.Image
import com.example.github.sample.exstension.inflate
import com.example.github.sample.exstension.loadImage
import com.example.github.sample.exstension.setOnDebouncedClickListener

class PhotoDetailsAdapter : ListAdapter<Image, PhotoDetailsViewHolder>(ImageDiffCallback()) {

    lateinit var onClickListener: ((Int) -> Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoDetailsViewHolder {
        return PhotoDetailsViewHolder(parent.inflate(R.layout.item_details_image))
    }

    override fun onBindViewHolder(holder: PhotoDetailsViewHolder, position: Int) {
        val currentImage = currentList[position]
        with(holder) {
            textDetails.text = textDetails.resources.getString(
                R.string.gallery_photo_details_image,
                position + 1, currentList.size
            )
            imagePhotoDetails.loadImage(currentImage.image)
            imagePhotoDetails.setOnDebouncedClickListener {
                onClickListener.invoke(holder.get())
            }
        }
    }
}
