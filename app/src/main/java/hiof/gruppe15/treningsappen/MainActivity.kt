package hiof.gruppe15.treningsappen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.treningsappen.R
import hiof.gruppe15.treningsappen.ui.theme.TreningsAppenTheme
import hiof.gruppe15.treningsappen.data.Datasource
import hiof.gruppe15.treningsappen.model.Exercise
import androidx.compose.ui.platform.LocalContext
import java.util.Locale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.times

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TreningsAppenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WorkoutApp()
                }
            }
        }
    }
}

@Composable
fun WorkoutApp() {
    val context = LocalContext.current
    val exercises = Datasource().loadExercisesFromJson(context)

    ExerciseList(exercises = exercises)
}

@Composable
fun ExerciseList(exercises: List<Exercise>, modifier: Modifier = Modifier) {
    LazyColumn(userScrollEnabled = true,
        modifier = modifier) {
        items(exercises.size) { index ->
            ExerciseCard(exercise = exercises[index])
        }
    }
}

@Composable
fun ExerciseCard(exercise: Exercise, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = exercise.name,
                style = MaterialTheme.typography.titleLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = exercise.description.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.ROOT
                    ) else it.toString()
                },
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = exercise.muscleGroup.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                            Locale.ROOT
                        ) else it.toString()
                    },
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.secondary
                )

                DifficultyIndicator(difficulty = exercise.difficulty)
            }
        }
    }
}

@Composable
fun DifficultyIndicator(difficulty: String) {
    val dashLength = 20.dp
    val dashWidth = 6.dp
    val dashSpacing = 4.dp
    val dashColor = when (difficulty.lowercase(Locale.ROOT)) {
        "easy" -> Color.hsl(111f, 1f, 0.4f)
        "medium" -> Color.hsl(210f, 1f, 0.4f)
        "hard" -> Color.hsl(0f, 1f, 0.4f)
        else -> MaterialTheme.colorScheme.onSurface // Default color if none matches
    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "Difficulty:",
            style = MaterialTheme.typography.bodySmall
        )

        Canvas(
            modifier = Modifier.size((3 * (dashLength + dashSpacing) - dashSpacing).value.dp, dashWidth)
        ) {
            val numberOfDashes = when (difficulty.lowercase(Locale.ROOT)) {
                "easy" -> 1
                "medium" -> 2
                "hard" -> 3
                else -> 0
            }

            for (i in 0 until numberOfDashes) {
                val startX = i * (dashLength.value + dashSpacing.value)
                drawLine(
                    color = dashColor,
                    start = Offset(startX, size.height / 2),
                    end = Offset(startX + dashLength.value, size.height / 2),
                    strokeWidth = dashWidth.value
                )
            }
        }
    }
}