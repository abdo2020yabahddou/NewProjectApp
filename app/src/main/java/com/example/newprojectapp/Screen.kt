package com.example.newprojectapp

import android.net.Uri

sealed class Screen(val route: String) {
    data object HomeScreen : Screen("home_screen")
    data object WelcomeScreen : Screen("welcome_screen/{name}/{lastName}/{email}/{password}") {
        fun createRoute(name: String, lastName: String, email: String, password: String) =
            "welcome_screen/${Uri.encode(name)}/${Uri.encode(lastName)}/${Uri.encode(email)}/${Uri.encode(password)}"
    }
}