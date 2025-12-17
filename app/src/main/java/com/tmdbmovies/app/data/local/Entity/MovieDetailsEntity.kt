package com.tmdbmovies.app.data.local.Entity

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie_details")
data class MovieDetailsEntity(
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
    val voteAverage: Double
)