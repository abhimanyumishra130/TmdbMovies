package com.tmdbmovies.app.domain.model

import com.google.gson.annotations.SerializedName

data class MovieResponseModel(
    @SerializedName("page")
    val page: Int?,

    @SerializedName("results")
    val results: List<MovieModel>?
)

/*
{
      "adult": false,
      "backdrop_path": "/ufqytAlziHq5pljKByGJ8IKhtEZ.jpg",
      "id": 425274,
      "title": "Now You See Me: Now You Don't",
      "original_title": "Now You See Me: Now You Don't",
      "overview": "The original Four Horsemen reunite with a new generation of illusionists to take on powerful diamond heiress Veronika Vanderberg, who leads a criminal empire built on money laundering and trafficking. The new and old magicians must overcome their differences to work together on their most ambitious heist yet.",
      "poster_path": "/oD3Eey4e4Z259XLm3eD3WGcoJAh.jpg",
      "media_type": "movie",
      "original_language": "en",
      "genre_ids": [
        53,
        80,
        9648
      ],
      "popularity": 123.0701,
      "release_date": "2025-11-12",
      "video": false,
      "vote_average": 6.317,
      "vote_count": 386
    },

    data class
 */

data class MovieModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("voteAverage")
    val voteAverage: Double,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("vote_count")
    val voteCount: Int,
    @SerializedName("popularity")
    val popularity: Double
)