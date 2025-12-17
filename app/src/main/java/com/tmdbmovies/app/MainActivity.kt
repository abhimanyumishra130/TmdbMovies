package com.tmdbmovies.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
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
        setContent {
            TmdbMoviesTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Blue)
                                .padding(20.dp)
                        ) {
                            Text(
                                text = "TakeHome Movies",
                                color = Color.White,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .wrapContentHeight()
                            )
                        }
                    }
                ) { innerPadding ->
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