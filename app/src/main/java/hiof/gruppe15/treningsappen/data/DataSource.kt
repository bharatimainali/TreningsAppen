package hiof.gruppe15.treningsappen.data

import android.content.Context
import com.example.treningsappen.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import hiof.gruppe15.treningsappen.model.Exercise
import java.io.IOException

class Datasource() {
    fun loadExercises(): List<Exercise> {
        return listOf<Exercise>(
            Exercise(
                1,
                "Barbell Curl",
                "Barbell curl is a free weights exercise that primarily targets the biceps.",
                "Bicep",
                "Easy"
            ),
            Exercise(
                2,
                "Tricep Pushdown",
                "Tricep pushdown is a exercise machine exercise that primarily targets the triceps.",
                "Triceps",
                "Medium"
            )
        )
    }

    fun loadExercisesFromJson(context: Context): List<Exercise> {
        val json: String
        try {
            val inputStream = context.resources.openRawResource(R.raw.exercises)
            json = inputStream.bufferedReader().use { it.readText() }
            val listType = object : TypeToken<List<Exercise>>() {}.type
            return Gson().fromJson(json, listType)
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return emptyList()
        }
    }
}