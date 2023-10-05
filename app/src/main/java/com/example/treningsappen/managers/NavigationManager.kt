package com.example.treningsappen.managers
import androidx.navigation.NavController
class NavigationManager(private val navController: NavController) {

    private val backStack = mutableListOf<String>()

    fun navigateToHome(destination: String) {
        navController.navigate(destination)

        backStack.add(destination)

    }

    fun navigateToProfile() {

        navController.navigate("profile")

        backStack.add("profile")

    }

    fun navigateBack() {
        if (backStack.isNotEmpty()) {
            val lastDestination = backStack.removeLast()
            navController.navigate(lastDestination)
        }
    }
}