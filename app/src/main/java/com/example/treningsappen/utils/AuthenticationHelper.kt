package com.example.treningsappen.utils

import com.google.firebase.auth.FirebaseAuth

class AuthenticationHelper {

    private val authInstance: FirebaseAuth = FirebaseAuth.getInstance()

    fun login(username: String, email: String, password: String) {
        if (Utils.validateEmail(email)) {
            // Continue with login
        }
    }

    fun logout() {

    }

    fun resetPassword(email: String) {

    }
    fun registerNewUser(email: String, password: String) {
        if (Utils.validateEmail(email)) {
            //Firebase user registration logic should be here implement
        }
    }
}