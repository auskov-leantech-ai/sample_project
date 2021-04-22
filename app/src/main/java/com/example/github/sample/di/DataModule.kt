package com.example.github.sample.di

import com.google.firebase.auth.FirebaseAuth
import org.koin.dsl.module

val dataModule = module {

    single { FirebaseAuth.getInstance() }
}

