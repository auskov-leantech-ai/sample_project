package com.example.github.sample.di

import androidx.room.Room
import com.example.github.sample.data.dao.SampleProjectDatabase
import com.example.github.sample.util.DatabaseConst
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(androidApplication(), SampleProjectDatabase::class.java, DatabaseConst.DATABASE_NAME)
            .build()
    }

    single { get<SampleProjectDatabase>().sampleProjectDao() }
}
