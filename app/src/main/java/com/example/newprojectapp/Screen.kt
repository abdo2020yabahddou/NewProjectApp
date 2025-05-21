package com.example.newprojectapp

sealed class Screen(val route: String) {
    data object HomeScreen : Screen("home_screen")
    data object WelcomeScreen : Screen("welcome_screen/{name}") {
        fun createRoute(name: String, lastName: String, email: String, password: String) =
            "welcome_screen/$name $lastName $email $password"
    }
}