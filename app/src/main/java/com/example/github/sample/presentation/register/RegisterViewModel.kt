package com.example.github.sample.presentation.register

import com.example.github.sample.R
import com.example.github.sample.presentation.base.BaseViewModel
import com.google.firebase.auth.FirebaseAuth

class RegisterViewModel(
    private val auth: FirebaseAuth
) : BaseViewModel() {

    fun fieldValidation(email: String, password: String, passwordRepeat: String) {
        when {
            email.isEmpty() -> postMessage(R.string.register_enter_email)
            password.isEmpty() -> postMessage(R.string.register_enter_password)
            passwordRepeat.isEmpty() -> postMessage(R.string.register_confirm_password)
            password != passwordRepeat -> postMessage(R.string.register_password_mismatch)
            else -> registerFirebaseAuth(email, password)
        }
    }

    private fun registerFirebaseAuth(email: String, password: String) {
        isInProgress.value = true
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    isInProgress.value = false
                    navigateTo(R.id.action_registerFragment_to_discoverFragment)
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
