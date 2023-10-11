package hiof.gruppe15.treningsappen.model

import androidx.annotation.DrawableRes

data class Exercise(
    val name: String,
    val description: String,
    val steps: List<String>,
    val difficulty: String,
    val muscleGroup: String,
)