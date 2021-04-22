package com.example.github.sample.presentation.welcome

import com.example.github.sample.R
import com.example.github.sample.presentation.base.BaseViewModel
import com.google.firebase.auth.FirebaseAuth

class WelcomeViewModel(private val auth: FirebaseAuth) : BaseViewModel() {

    fun getCurrentUser() {
        if (auth.currentUser != null) {
            navigateTo(R.id.action_welcomeFragment_to_discoverFragment)
        }
    }

    fun navigateToLogin() {
        navigateTo(R.id.action_welcomeFragment_to_loginFragment)
    }

    fun navigateToRegister() {
        navigateTo(R.id.action_welcomeFragment_to_registerFragment)
    }
}
