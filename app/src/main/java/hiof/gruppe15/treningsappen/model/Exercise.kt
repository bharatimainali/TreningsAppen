package hiof.gruppe15.treningsappen.model

import androidx.annotation.DrawableRes

data class Exercise(
    val id: String,
    val name: String,
    val description: String,
    @DrawableRes val image: Int,
    val muscleGroup: String,
    val difficultyLevel: String
)