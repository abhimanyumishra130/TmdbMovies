package com.tmdbmovies.app.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.tmdbmovies.app.domain.model.MovieModel
import com.tmdbmovies.app.presentation.viewmodel.MainViewModel

@Composable
fun MovieDetailsScreen(id: Int?, mainViewModel: MainViewModel) {
    // Implementation for Movie Details Screen goes here
    Log.d("TAG", "MovieDetailsScreen: $id")
    id?:return
    var movieModel by remember { mutableStateOf<MovieModel?>(null) }
    LaunchedEffect(null) {
        movieModel = mainViewModel.getMovieById(id)
    }
    Log.d("TAG", "MovieDetailsScreen: ${movieModel}")
    Log.d("TAG", "MovieDetailsScreen: https://image.tmdb.org/t/p/w500/${movieModel?.posterPath}")

    Column(modifier = Modifier.fillMaxSize().background(Color.White).padding(20.dp,70.dp, 20.dp, 20.dp)) {
        AsyncImage(
            contentDescription = "",
            model = "https://image.tmdb.org/t/p/w500/${movieModel?.posterPath}",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth()
        )
        Spacer(modifier = Modifier.padding(15.dp))
        Text(
            text = "Title: ${movieModel?.title}",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Overview:- ${movieModel?.overview}",
            color = Color.Black,
            style = MaterialTheme.typography.bodyLarge,
            fontFamily = FontFamily.SansSerif,
        )
    }
}