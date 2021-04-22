package com.example.github.sample.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.github.sample.domain.entity.Photo
import com.example.github.sample.util.DatabaseConst

@Database(entities = [Photo::class], version = DatabaseConst.DATABASE_VERSION_1)
abstract class SampleProjectDatabase : RoomDatabase() {

    abstract fun sampleProjectDao() : PhotoDao
}
