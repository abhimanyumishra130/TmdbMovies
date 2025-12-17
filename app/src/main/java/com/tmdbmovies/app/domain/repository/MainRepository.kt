package com.tmdbmovies.app.domain.repository

import com.tmdbmovies.app.domain.model.MovieResponseModel

interface MainRepository {
    suspend fun fetchMovies(): MovieResponseModel
}