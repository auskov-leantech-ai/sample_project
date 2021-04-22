package com.example.github.sample.presentation.gallery_photo_details

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.github.sample.domain.entity.Image
import com.example.github.sample.domain.repository.PhotoRepository
import com.example.github.sample.presentation.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class GalleryPhotoDetailsViewModel(private val photoRepository: PhotoRepository) : BaseViewModel() {

    val listImageLiveData = MutableLiveData<List<Image>>()

    init {
        getImages()
    }

    private fun getImages() {
        photoRepository.getImages()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { list ->
                    listImageLiveData.value = list
                    Log.d("listImageLiveData", "${listImageLiveData.value.toString()}")
                },
                onError = { it.localizedMessage }
            ).addTo(disposable)
    }
}
