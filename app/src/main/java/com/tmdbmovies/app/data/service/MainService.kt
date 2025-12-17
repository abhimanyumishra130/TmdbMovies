package com.tmdbmovies.app.data.service

import com.tmdbmovies.app.domain.model.MovieResponseModel
import retrofit2.http.GET

interface MainService {
    @GET("day?language=en-US")
    suspend fun fetchMovies(): MovieResponseModel
}