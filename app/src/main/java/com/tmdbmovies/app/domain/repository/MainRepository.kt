package com.tmdbmovies.app.domain.repository

import com.tmdbmovies.app.domain.model.MovieModel
import com.tmdbmovies.app.domain.model.MovieResponseModel
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun fetchMovies(): MovieResponseModel
     fun fetchAllMovies(): Flow<List<MovieModel>>
    suspend fun insertMovies(movies: List<MovieModel>)
    suspend fun deleteAllMovies()
    suspend fun searchMovies(query: String): Flow<List<MovieModel>>
    suspend fun getMovieById(movieId: Int): MovieModel?
}