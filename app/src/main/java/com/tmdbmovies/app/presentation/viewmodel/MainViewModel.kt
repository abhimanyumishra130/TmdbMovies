package com.tmdbmovies.app.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tmdbmovies.app.domain.model.MovieModel
import com.tmdbmovies.app.domain.usecase.FetchMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val fetchMoviesUseCase: FetchMoviesUseCase) : ViewModel() {

    private val _movies = MutableStateFlow<List<MovieModel>?>(null)
    val movies = _movies

    init {
        fetchMovies()
    }
    fun fetchMovies() {
        // Implementation goes here
        viewModelScope.launch {
            try {
                val result = fetchMoviesUseCase()
                Log.d("TAG", "fetchMovies: ${result.results}")
                _movies.emit(result.results)
            }catch (e: Exception) {
                // Handle error
                Log.d("TAG", "fetchMovies: ${e.message}")
            }
        }
    }

}