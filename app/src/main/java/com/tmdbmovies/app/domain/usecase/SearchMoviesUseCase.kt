package com.tmdbmovies.app.domain.usecase

import com.tmdbmovies.app.domain.repository.MainRepository
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(val mainRepository: MainRepository){
    suspend operator fun invoke(query: String) =
        mainRepository.searchMovies(query)
}