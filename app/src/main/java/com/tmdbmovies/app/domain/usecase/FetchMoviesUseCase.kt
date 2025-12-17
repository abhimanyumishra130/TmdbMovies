package com.tmdbmovies.app.domain.usecase

import com.tmdbmovies.app.domain.repository.MainRepository
import javax.inject.Inject

class FetchMoviesUseCase @Inject constructor(val mainRepository: MainRepository) {
    suspend operator fun invoke() = mainRepository.fetchMovies()
}