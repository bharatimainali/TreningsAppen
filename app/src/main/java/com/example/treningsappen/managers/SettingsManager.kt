package com.example.treningsappen.managers

import android.content.SharedPreferences

class SettingsManager(private val userPreferences: SharedPreferences) {

    private val defaultAppSettings: Map<String, Any> = mapOf(
        "theme" to "Light",
        "language" to "English"
    )
    fun updateSettings(setting: String, value: Any){
        val editor = userPreferences.edit()
        when(value){
            is String -> editor.putString(setting, value)
            is Int -> editor.putInt(setting, value)
            is Boolean -> editor.putBoolean(setting, value)
        }
        editor.apply()
    }
    fun loadUserPreferences(): Map<String, *> {
        return userPreferences.all
    }
    fun saveUserPreferences() {
        val editor = userPreferences.edit()
        for ((key, value) in defaultAppSettings) {
            when (value) {
                is String -> editor.putString(key, value)
                is Int -> editor.putInt(key, value)
                is Boolean -> editor.putBoolean(key, value)
            }
        }
        editor.apply()
    }
}
