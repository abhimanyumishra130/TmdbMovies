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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.tmdbmovies.app.core.utils.MoviePosterUtils
import com.tmdbmovies.app.presentation.viewmodel.MainViewModel

@Composable
fun HomeScreen(viewModel: MainViewModel, onItemClick: (Int) -> Unit = {}) {
    Log.d("TAG", "HomeScreens: ")
    val result by viewModel.movies.collectAsState()
    LazyVerticalGrid(
        modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(20.dp,60.dp,20.dp,0.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        columns = GridCells.Fixed(2)
    ) {
        result?.let {
            items(it.size){ ind ->
                val url = MoviePosterUtils.getFullPosterUrl(it[ind].posterPath)
                val title = it[ind].title
                MovieModel(url, title, onItemClick = { onItemClick(ind) })
            }
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
