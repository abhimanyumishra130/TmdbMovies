package com.tmdbmovies.app.core.di

import android.content.Context
import androidx.room.Room
import com.tmdbmovies.app.data.local.dao.MoviesDao
import com.tmdbmovies.app.data.local.database.MoviesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MoviesDatabase {
        // Placeholder for actual database provision logic
        return Room.databaseBuilder(context, MoviesDatabase::class.java, "movies_database").build()
    }

    @Provides
    @Singleton
    fun provideMoviesDao(database: MoviesDatabase): MoviesDao = database.getMoviesDao()
}