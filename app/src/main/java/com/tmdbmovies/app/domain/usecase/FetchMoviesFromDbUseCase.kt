package com.tmdbmovies.app.domain.usecase

import com.tmdbmovies.app.domain.model.MovieModel
import com.tmdbmovies.app.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchMoviesFromDbUseCase @Inject constructor(val mainRepository: MainRepository) {
     operator fun invoke(): Flow<List<MovieModel>> {
        // Implementation to fetch movies from the database
        return mainRepository.fetchAllMovies()
    }
}