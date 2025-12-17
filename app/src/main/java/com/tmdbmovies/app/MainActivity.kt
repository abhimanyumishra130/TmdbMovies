package com.tmdbmovies.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tmdbmovies.app.presentation.navigation.MainNavigation
import com.tmdbmovies.app.presentation.screens.HomeScreen
import com.tmdbmovies.app.presentation.ui.theme.TmdbMoviesTheme
import com.tmdbmovies.app.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TmdbMoviesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InitiateUI()
                }
            }
        }
    }
}

@Composable
fun InitiateUI(viewModel: MainViewModel = hiltViewModel()) {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "home"
    MainNavigation(
        navController = navController,
        startDestination = "home"
    )
}