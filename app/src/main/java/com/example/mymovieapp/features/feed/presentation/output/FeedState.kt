package com.example.mymovieapp.features.feed.presentation.output

import com.example.mymovieapp.features.common.entity.CategoryEntity
import com.example.mymovieapp.features.common.entity.MovieFeedItemEntity

sealed class FeedState {
    data object Loading: FeedState()
    data class Main(val categories: List<CategoryEntity>) : FeedState()
    data class Failed(val reason: String): FeedState()
}