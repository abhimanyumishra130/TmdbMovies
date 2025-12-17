package com.tmdbmovies.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.tmdbmovies.app.domain.model.MovieModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _movies = MutableStateFlow<List<MovieModel>?>(null)
    val movies = _movies

}