package com.tmdbmovies.app.core.utils

object MoviePosterUtils {
    val imageBaseUrl = "https://image.tmdb.org/t/p/w500/"
    fun getFullPosterUrl(posterPath: String): String {
        return if (posterPath != null) {
            "$imageBaseUrl$posterPath"
        } else {
            ""
        }
    }
}