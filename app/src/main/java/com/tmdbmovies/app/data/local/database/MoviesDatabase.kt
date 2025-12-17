package com.tmdbmovies.app.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tmdbmovies.app.data.local.Entity.MovieDetailsEntity
import com.tmdbmovies.app.data.local.dao.MoviesDao

@Database(entities = [MovieDetailsEntity::class], version = 1, exportSchema = false)
abstract class MoviesDatabase: RoomDatabase(){

    abstract fun getMoviesDao(): MoviesDao

}