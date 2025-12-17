package com.tmdbmovies.app.data.mapper

import com.tmdbmovies.app.data.local.Entity.MovieDetailsEntity
import com.tmdbmovies.app.domain.model.MovieModel

fun MovieDetailsEntity.toMovieModel(): MovieModel {
    return MovieModel(
        id = this.id,
        title = this.title,
        overview = this.overview,
        releaseDate = this.releaseDate,
        posterPath = this.posterPath,
        backdropPath = this.backdropPath,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount,
        popularity = this.popularity
    )
}

fun MovieModel.toMovieDetailsEntity(): MovieDetailsEntity {
    return MovieDetailsEntity(
        id = this.id,
        title = this.title,
        overview = this.overview,
        releaseDate = this.releaseDate,
        posterPath = this.posterPath,
        backdropPath = this.backdropPath,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount,
        popularity = this.popularity
    )
}

fun List<MovieDetailsEntity>.toMovieModelList(): List<MovieModel> {
    return this.map { it.toMovieModel() }
}