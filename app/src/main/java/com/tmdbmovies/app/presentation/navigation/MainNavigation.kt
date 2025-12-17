package com.tmdbmovies.app.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tmdbmovies.app.presentation.screens.HomeScreen
import com.tmdbmovies.app.presentation.screens.MovieDetailsScreen
import com.tmdbmovies.app.presentation.viewmodel.MainViewModel

@Composable
fun MainNavigation(
    navController: NavHostController,
    startDestination: String = "home",
    mainViewModel: MainViewModel = hiltViewModel()
) {
    // Navigation implementation goes here

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable("home"){
            HomeScreen(mainViewModel){ ind ->
                Log.d("TAG", "MainNavigation: $ind")
                navController.navigate("details/$ind")
            }
        }

        composable("details/{movieId}"){
            MovieDetailsScreen(id = it.arguments?.getString("movieId")?.toInt(), mainViewModel)
        }
    }
}