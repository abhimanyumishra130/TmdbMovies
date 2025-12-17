package com.tmdbmovies.app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tmdbmovies.app.data.local.Entity.MovieDetailsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDao {

    @Query("SELECT * FROM movie_details")
    fun fetchMovies(): Flow<List<MovieDetailsEntity>>

    @Query("SELECT * FROM movie_details WHERE title LIKE '%' || :query || '%'")
    fun searchMovies(query: String): Flow<List<MovieDetailsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieDetailsEntity>)

    @Query("SELECT * FROM movie_details WHERE id = :movieId")
    suspend fun getMovieById(movieId: Int): MovieDetailsEntity?

    @Query("DELETE FROM movie_details")
    suspend fun deleteAllMovies()

}