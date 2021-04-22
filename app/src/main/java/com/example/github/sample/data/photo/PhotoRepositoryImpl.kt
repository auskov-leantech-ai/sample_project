package com.example.github.sample.data.photo

import com.example.github.sample.data.dao.PhotoDao
import com.example.github.sample.domain.entity.Image
import com.example.github.sample.domain.entity.Photo
import com.example.github.sample.domain.repository.PhotoRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class PhotoRepositoryImpl(private val sampleProjectDao: PhotoDao) : PhotoRepository {

    override fun getPhotos(): Observable<List<Photo>> = sampleProjectDao.getPhotos()

    override fun getImages(): Single<List<Image>>  = sampleProjectDao.getImages()

    override fun insertPhoto(photo: Photo): Completable = sampleProjectDao.insertPhoto(photo)

    override fun deletePhoto(photo: Photo): Completable = sampleProjectDao.deletePhoto(photo)
}
