package com.example.treningsappen.models

import com.example.treningsappen.utils.DatabaseHelper

data class ExerciseClass(
    val exerciseID: String,
    val exerciseName: String,
    val exerciseDescription: String,
    val exerciseImage: String,
    val exerciseMuscleGroup: String,
    val difficultyLevel: String
) {
    fun addExercise() {

    }

    fun editExercise() {
    }

    fun deleteExercise() {

    }
}
