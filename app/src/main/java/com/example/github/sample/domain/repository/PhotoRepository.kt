package com.example.github.sample.domain.repository

import com.example.github.sample.domain.entity.Image
import com.example.github.sample.domain.entity.Photo
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface PhotoRepository {

    fun getPhotos(): Observable<List<Photo>>

    fun getImages(): Single<List<Image>>

    fun insertPhoto(photo: Photo): Completable

    fun deletePhoto(photo: Photo): Completable
}
