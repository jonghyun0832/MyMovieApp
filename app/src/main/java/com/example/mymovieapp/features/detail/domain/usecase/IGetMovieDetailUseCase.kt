package com.example.mymovieapp.features.detail.domain.usecase

import com.example.mymovieapp.features.common.entity.MovieDetailEntity

interface IGetMovieDetailUseCase {
    suspend operator fun invoke(name: String): MovieDetailEntity
}
