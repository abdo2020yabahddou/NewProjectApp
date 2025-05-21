@file:Suppress("NAME_SHADOWING")

package com.example.newprojectapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    lastName: String = "",
    email: String = "",
    password: String = ""
) {
    val viewModel: HomeViewModel = viewModel()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            HomeView(viewModel, navController)
        }
        composable(
            Screen.WelcomeScreen.route,
            arguments = listOf(navArgument("name") { type = NavType.StringType },
                navArgument("lastName") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType },
                navArgument("password") { type = NavType.StringType })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val lastName = backStackEntry.arguments?.getString("lastName") ?: ""
            val email = backStackEntry.arguments?.getString("email") ?: ""
            val password = backStackEntry.arguments?.getString("password") ?: ""
            WelcomeView(name, lastName, email, password, navController)
        }

    }
}



