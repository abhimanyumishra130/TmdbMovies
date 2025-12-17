package com.tmdbmovies.app.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tmdbmovies.app.core.utils.NetworkConnectivityObserver
import com.tmdbmovies.app.core.utils.NetworkUtils
import com.tmdbmovies.app.domain.model.MovieModel
import com.tmdbmovies.app.domain.usecase.FetchMovieByIdUseCase
import com.tmdbmovies.app.domain.usecase.FetchMoviesFromDbUseCase
import com.tmdbmovies.app.domain.usecase.FetchMoviesUseCase
import com.tmdbmovies.app.domain.usecase.SearchMoviesUseCase
import com.tmdbmovies.app.presentation.state.MainUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val fetchMoviesUseCase: FetchMoviesUseCase,
    val fetchMoviesFromDbUseCase: FetchMoviesFromDbUseCase,
    val fetchMovieByIdUseCase: FetchMovieByIdUseCase,
    val searchMoviesUseCase: SearchMoviesUseCase,
    val networkConnectivityObserver: NetworkConnectivityObserver,
    val networkUtils: NetworkUtils
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

    private val _uiState = MutableStateFlow<MainUiState>(MainUiState.Idle)
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()
    private var shouldRetryOnConnection = false

    init {
        fetchMovies()
        observeNetworkConnectivity()
    }

    private fun observeNetworkConnectivity() {
        viewModelScope.launch {
            networkConnectivityObserver.isConnected.collect { isConnected ->
                Log.d("TAG", "Network connectivity changed: $isConnected")
                if (isConnected && shouldRetryOnConnection) {
                    Log.d("TAG", "Network restored, retrying fetch")
                    shouldRetryOnConnection = false
                    fetchMovies()
                }
            }
        }
    }
    fun fetchMovies() {
        // Implementation goes here
        viewModelScope.launch {
            if (!networkUtils.isNetworkAvailable()) {
                Log.d("TAG", "fetchMovies: No network available")
                shouldRetryOnConnection = true
//                _uiState.emit(MainUiState.Error("No internet connection available"))
                return@launch
            }

            // Set loading state
            _uiState.emit(MainUiState.Loading)
            Log.d("TAG", "fetchMovies: Loading started")
            try {
                val result = fetchMoviesUseCase()
//
//                Log.d("TAG", "fetchMovies: ${result.results}")
//                _movies.emit(result.results)
                _uiState.emit(MainUiState.Success(result.results))
                shouldRetryOnConnection = false
//                val result = fetchMoviesFromDbUseCase()
//                _movies.emit(result)
            }catch (e: Exception) {
                // Handle error
                _uiState.emit(MainUiState.Error(e.message ?: "Unknown error occurred"))
                shouldRetryOnConnection = true
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