package com.tmdbmovies.app.data.repository

import com.tmdbmovies.app.data.local.dao.MoviesDao
import com.tmdbmovies.app.data.mapper.toMovieDetailsEntity
import com.tmdbmovies.app.data.mapper.toMovieModel
import com.tmdbmovies.app.data.mapper.toMovieModelList
import com.tmdbmovies.app.data.service.MainService
import com.tmdbmovies.app.domain.model.MovieModel
import com.tmdbmovies.app.domain.model.MovieResponseModel
import com.tmdbmovies.app.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(val mainService: MainService, val moviesDao: MoviesDao): MainRepository{

    override suspend fun fetchMovies(): MovieResponseModel {
        // Implementation goes here
        val result =  mainService.fetchMovies()
        result.results?.let {
            insertMovies(it)
        }
        return result
    }

    override  fun fetchAllMovies(): Flow<List<MovieModel>> {
        return moviesDao.fetchMovies().map {
            it.toMovieModelList()
        }
    }

    override suspend fun insertMovies(movies: List<MovieModel>) {
        val moviesEntity = movies.map { it.toMovieDetailsEntity() }
        moviesDao.insertMovies(moviesEntity)
    }

    override suspend fun deleteAllMovies() {
        moviesDao.deleteAllMovies()
    }

    override suspend fun searchMovies(query: String): Flow<List<MovieModel>> {
        return moviesDao.searchMovies(query).map { it.toMovieModelList() }
    }

    override suspend fun getMovieById(movieId: Int): MovieModel? {
        return moviesDao.getMovieById(movieId)?.toMovieModel()
    }

}