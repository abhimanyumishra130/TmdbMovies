package com.tmdbmovies.app.presentation.state

import com.tmdbmovies.app.domain.model.MovieModel

sealed class MainUiState {
    object Idle : MainUiState()
    object Loading : MainUiState()
    data class Success(val movies: List<MovieModel>?) : MainUiState()
    data class Error(val message: String) : MainUiState()
}