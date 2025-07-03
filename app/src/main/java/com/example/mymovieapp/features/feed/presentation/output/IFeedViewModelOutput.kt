package com.example.mymovieapp.features.feed.presentation.output

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface IFeedViewModelOutput {
    val feedState: StateFlow<FeedState>
    val feedInfoDialogState: StateFlow<Boolean>
    val feedUiEffect: SharedFlow<FeedUiEffect>
}

sealed class FeedUiEffect {
    data class OpenMovieDetail(val movieName: String): FeedUiEffect()
}