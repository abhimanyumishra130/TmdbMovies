package com.tmdbmovies.app.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tmdbmovies.app.domain.model.MovieModel
import com.tmdbmovies.app.domain.usecase.FetchMovieByIdUseCase
import com.tmdbmovies.app.domain.usecase.FetchMoviesFromDbUseCase
import com.tmdbmovies.app.domain.usecase.FetchMoviesUseCase
import com.tmdbmovies.app.domain.usecase.SearchMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val fetchMoviesUseCase: FetchMoviesUseCase,
    val fetchMoviesFromDbUseCase: FetchMoviesFromDbUseCase,
    val fetchMovieByIdUseCase: FetchMovieByIdUseCase,
    searchMoviesUseCase: SearchMoviesUseCase
) : ViewModel() {

private val searchQuery = MutableStateFlow("")
    private val _movies = searchQuery.flatMapLatest {
        query ->
        if (query.isEmpty()) {
            fetchMoviesFromDbUseCase()
        } else {
            searchMoviesUseCase(query)
        }
    }
    val movies = _movies

    init {
        fetchMovies()
    }
    fun fetchMovies() {
        // Implementation goes here
        viewModelScope.launch {
            try {
//                val result = fetchMoviesUseCase()
//
//                Log.d("TAG", "fetchMovies: ${result.results}")
//                _movies.emit(result.results)
                fetchMoviesUseCase()
//                val result = fetchMoviesFromDbUseCase()
//                _movies.emit(result)
            }catch (e: Exception) {
                // Handle error
                Log.d("TAG", "fetchMovies: ${e.message}")
            }
        }
    }

    fun searchMovies(query: String) {
        // Implementation goes here
        // You can implement search functionality here if needed
        searchQuery.value = query
    }

    suspend fun getMovieById(movieId: Int): MovieModel? {
        // Implementation goes here
        return fetchMovieByIdUseCase(movieId)
    }

}