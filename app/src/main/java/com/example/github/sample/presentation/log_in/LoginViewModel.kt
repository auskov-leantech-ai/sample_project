package com.example.github.sample.presentation.log_in

import com.example.github.sample.R
import com.example.github.sample.presentation.base.BaseViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel(private val auth: FirebaseAuth) : BaseViewModel() {

    fun fieldValidation(email: String, password: String) {
        when {
            email.isEmpty() -> postMessage(R.string.register_enter_email)
            password.isEmpty() -> postMessage(R.string.register_enter_password)
            else -> loginFirebaseAuth(email, password)
        }
    }

    private fun loginFirebaseAuth(email: String, password: String) {
        isInProgress.value = true
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    isInProgress.value = false
                    navigateTo(R.id.action_loginFragment_to_discoverFragment)
                } else {
                    postMessage(task.exception?.localizedMessage)
                }
            }
            .addOnFailureListener { exception ->
                isInProgress.value = false
                postMessage(exception.localizedMessage)
            }
    }

    fun navigateToBack() {
        navController.navigateUp()
    }
}
