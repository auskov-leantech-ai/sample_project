package com.example.github.sample.di

import com.example.github.sample.data.photo.PhotoRepositoryImpl
import com.example.github.sample.domain.repository.PhotoRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<PhotoRepository> { PhotoRepositoryImpl(get()) }
}
