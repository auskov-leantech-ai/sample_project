package com.example.github.sample.di

import com.example.github.sample.presentation.action_choice_dialog.ActionChoicePhotoViewModel
import com.example.github.sample.presentation.gallery_photo.PhotoGalleryViewModel
import com.example.github.sample.presentation.gallery_photo_details.GalleryPhotoDetailsViewModel
import com.example.github.sample.presentation.log_in.LoginViewModel
import com.example.github.sample.presentation.map.MapViewModel
import com.example.github.sample.presentation.register.RegisterViewModel
import com.example.github.sample.presentation.welcome.WelcomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { RegisterViewModel(get()) }

    viewModel { LoginViewModel(get()) }

    viewModel { WelcomeViewModel(get()) }

    viewModel { PhotoGalleryViewModel(get()) }

    viewModel { ActionChoicePhotoViewModel(get()) }

    viewModel { MapViewModel() }

    viewModel { GalleryPhotoDetailsViewModel(get()) }
}
