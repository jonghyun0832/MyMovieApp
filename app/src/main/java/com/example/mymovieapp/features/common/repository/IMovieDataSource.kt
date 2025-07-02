package com.example.mymovieapp.features.common.repository

import com.example.mymovieapp.features.common.entity.CategoryEntity
import com.example.mymovieapp.features.common.entity.EntityWrapper
import com.example.mymovieapp.features.common.entity.MovieDetailEntity
import com.example.mymovieapp.features.feed.domain.enum.SortOrder

interface IMovieDataSource {
    suspend fun getCategories(sortOrder: SortOrder? = null): EntityWrapper<List<CategoryEntity>>
    suspend fun getMovieDetail(movieName: String): MovieDetailEntity
}