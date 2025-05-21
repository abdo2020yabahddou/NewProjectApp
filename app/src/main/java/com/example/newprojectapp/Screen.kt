package com.example.newprojectapp

import android.net.Uri

sealed class Screen(val route: String) {
    data object HomeScreen : Screen("home_screen")
    data object WelcomeScreen : Screen("welcome_screen/{name}/{lastName}/{email}/{password}/{userId}") {
        fun createRoute(
            name: String,
            lastName: String,
            email: String,
            password: String,
            userId: String
        ) =
            "welcome_screen/${Uri.encode(name)}/${Uri.encode(lastName)}/${Uri.encode(email)}/${
                Uri.encode(password)
            }/${Uri.encode(userId)}"
    }
}