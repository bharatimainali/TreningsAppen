package com.example.treningsappen.models

data class Exercise(
    val exerciseID: String,
    val exerciseName: String,
    val exerciseDescription: String,
    val exerciseImage: String,
    val exerciseMuscleGroup: String,
    val difficultyLevel: String
) {
    class ExcerciseOperation {
        private val exercises = ArrayList<Exercise>()
        fun addExercise(exercise: Exercise) {

        }

        fun editExercise(updateExercise: Exercise) {
        }

        fun deleteExercise(exercise: Exercise) {

        }

        fun getExerciseInfo(exerciseID: String): Exercise? {
            return null
        }
    }
}
