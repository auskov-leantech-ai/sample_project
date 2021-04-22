package com.example.github.sample.presentation.gallery_photo.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.github.sample.R
import com.example.github.sample.domain.entity.Photo
import com.example.github.sample.exstension.inflate
import com.example.github.sample.exstension.loadImage
import com.example.github.sample.exstension.setOnDebouncedClickListener

class PhotoAdapter : ListAdapter<Photo, RecyclerView.ViewHolder>(PhotoDiffCallback()) {

    lateinit var onDeleteClickListener: ((Photo) -> Unit)
    lateinit var onAddClickListener: ((Unit) -> Unit)
    lateinit var onClickListener: ((Unit) -> Unit)
    lateinit var onBindListener: ((Int) -> Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_photo -> {
                PhotoViewHolder(parent.inflate(R.layout.item_photo))
            }
            R.layout.item_button_photo_add -> {
                PlaceholderViewHolder(parent.inflate(R.layout.item_button_photo_add))
            }
            else -> throw IllegalArgumentException("unknown view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            R.layout.item_photo -> {
                val currentPhoto = currentList[position]
                (holder as PhotoViewHolder)
                with(holder) {
                    bind(currentPhoto)
                    imagePhoto.loadImage(currentPhoto.image)
                    imagePhoto.setOnDebouncedClickListener {
                        onBindListener.invoke(get())
                    }
                    deletePhoto.setOnDebouncedClickListener {
                        onDeleteClickListener.invoke(currentPhoto)
                    }
//                    imagePhoto.setOnDebouncedClickListener {
//                        onClickListener.invoke(Unit)
//                    }
                }
            }
            R.layout.item_button_photo_add -> {
                (holder as PlaceholderViewHolder)
                holder.photoAdd.setOnDebouncedClickListener {
                    onAddClickListener.invoke(Unit)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            currentList.size -> R.layout.item_button_photo_add
            else -> R.layout.item_photo
        }
    }

    override fun getItemCount(): Int {
        return currentList.size + 1
    }
}

