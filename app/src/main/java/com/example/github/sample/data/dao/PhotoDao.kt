package com.example.github.sample.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.github.sample.domain.entity.Image
import com.example.github.sample.domain.entity.Photo
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface PhotoDao {

    @Query("SELECT * FROM Photo ORDER BY id")
    fun getPhotos(): Observable<List<Photo>>

    @Query("SELECT image FROM Photo")
    fun getImages(): Single<List<Image>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPhoto(photo: Photo): Completable

    @Update
    fun updatePhoto(photo: Photo): Completable

    @Delete
    fun deletePhoto(photo: Photo): Completable
}
