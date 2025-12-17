package com.tmdbmovies.app.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.tmdbmovies.app.core.utils.MoviePosterUtils
import com.tmdbmovies.app.presentation.viewmodel.MainViewModel

@Composable
fun HomeScreen(viewModel: MainViewModel, onItemClick: (Int) -> Unit = {}) {
    Log.d("TAG", "HomeScreens: ")
    val result by viewModel.movies.collectAsState(null)
    var searchQuery by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(top = 60.dp)
    ) {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            placeholder = { Text(text = "Search Movies") }
        )
        LazyVerticalGrid(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            result?.let {
                items(it.size){ ind ->
                    val movie = it[ind]
                    val url = MoviePosterUtils.getFullPosterUrl(movie.posterPath)
                    val title = movie.title
                    MovieModel(url, title, onItemClick = { onItemClick(movie.id) })
                }
            }
        }

        LaunchedEffect(searchQuery) {
            viewModel.searchMovies(searchQuery)
        }
    }
}


@Composable
fun MovieModel(url: String, title: String, onItemClick: () -> Unit){
    Box (modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(10.dp)
        .clickable{ onItemClick() }
    ){
        Column {
            AsyncImage(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                model = url,
                contentDescription = ""
            )

            Text(text = title, color = Color.Black)
        }
    }
}
