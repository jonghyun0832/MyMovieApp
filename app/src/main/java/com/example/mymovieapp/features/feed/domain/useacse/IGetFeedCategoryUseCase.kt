package com.example.mymovieapp.features.feed.domain.useacse

import com.example.mymovieapp.features.common.entity.CategoryEntity
import com.example.mymovieapp.features.common.entity.EntityWrapper
import com.example.mymovieapp.features.feed.domain.enum.SortOrder

interface IGetFeedCategoryUseCase {
    suspend operator fun invoke(sortOrder: SortOrder? = null): EntityWrapper<List<CategoryEntity>>
}