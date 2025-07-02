package com.example.mymovieapp.features.feed.domain.useacse

import com.example.mymovieapp.features.common.entity.CategoryEntity
import com.example.mymovieapp.features.common.entity.EntityWrapper
import com.example.mymovieapp.features.common.repository.IMovieDataSource
import com.example.mymovieapp.features.feed.domain.enum.SortOrder
import javax.inject.Inject

class GetFeedCategoryUseCase @Inject constructor(
    private val dataSource: IMovieDataSource
): IGetFeedCategoryUseCase {
    override suspend fun invoke(sortOrder: SortOrder?): EntityWrapper<List<CategoryEntity>> {
        return dataSource.getCategories(sortOrder)
    }
}