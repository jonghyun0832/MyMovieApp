package com.example.mymovieapp.features.detail.presentation.output

import com.example.mymovieapp.features.common.entity.MovieDetailEntity

sealed class MovieDetailState {
    data object Initial : MovieDetailState()
    class Main(val movieDetailEntity: MovieDetailEntity) : MovieDetailState()
}
