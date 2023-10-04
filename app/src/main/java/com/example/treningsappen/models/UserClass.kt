package com.example.treningsappen.models

import com.example.treningsappen.utils.AuthenticationHelper

data class UserClass(
    val userID: String,
    val userName: String,
    val userEmail: String,
    val userProfilePic: String,
    val userPreferences: Map<String, Any>
) {
    fun login() {
        val authenticationHelper = AuthenticationHelper()
    }

    fun logout() {

    }

    fun updateProfile() {

    }

    fun changeSettings() {

    }
}