package com.example.mymovieapp.features.detail.domain.usecase

import com.example.mymovieapp.features.common.entity.MovieDetailEntity
import com.example.mymovieapp.features.common.repository.IMovieDataSource
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val dataSource: IMovieDataSource
) : IGetMovieDetailUseCase {
    override suspend fun invoke(name: String): MovieDetailEntity {
        return dataSource.getMovieDetail(name)
    }
}
