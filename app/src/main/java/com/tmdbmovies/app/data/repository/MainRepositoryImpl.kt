package com.tmdbmovies.app.data.repository

import com.tmdbmovies.app.data.service.MainService
import com.tmdbmovies.app.domain.model.MovieResponseModel
import com.tmdbmovies.app.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(val mainService: MainService): MainRepository{

    override suspend fun fetchMovies(): MovieResponseModel {
        // Implementation goes here
        return mainService.fetchMovies()
    }

}