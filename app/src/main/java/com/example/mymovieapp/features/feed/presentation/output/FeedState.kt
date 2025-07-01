package com.example.mymovieapp.features.feed.presentation.output

sealed class FeedState {
    data object Loading: FeedState()
    data class Main(val movieList = List<MovieFeedItemEntity>): FeedState()
    data class Failed(val reason: String): FeedState()
}