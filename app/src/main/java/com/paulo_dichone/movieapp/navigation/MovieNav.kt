package com.paulo_dichone.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.paulo_dichone.movieapp.screens.HomeScreen
import com.paulo_dichone.movieapp.screens.details.DetailScreen

@Composable
fun MovieNav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreen.HomeScreen.name) {
        composable(MovieScreen.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(
            MovieScreen.DetailScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") {
                type = NavType.StringType
            })
        ) {
            DetailScreen(navController = navController, it.arguments?.getString("movie"))
        }
    }
}

