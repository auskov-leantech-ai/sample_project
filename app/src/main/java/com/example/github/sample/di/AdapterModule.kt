package com.example.github.sample.di

import com.example.github.sample.presentation.gallery_photo.adapter.PhotoAdapter
import com.example.github.sample.presentation.gallery_photo_details.adapter.PhotoDetailsAdapter
import org.koin.dsl.module

val adapterModule = module {

    single { PhotoAdapter() }

    single { PhotoDetailsAdapter() }
}
