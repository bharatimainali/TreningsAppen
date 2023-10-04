package com.example.treningsappen.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.treningsappen.R
import com.example.treningsappen.R.layout.fragment_home_screen
import com.example.treningsappen.models.ExerciseClass
import com.example.treningsappen.models.TrainingPlanClass

class HomeScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sampleExercise = ExerciseClass(
            "1", "Push Up", "A basic push-up exercise.",
            "image_url", "Chest", "Beginner"
        )

        val sampleTrainingPlan = TrainingPlanClass(
            "1", "1", "Beginner Plan", listOf("Push Up", "Sit Up")
        )
    }
}
