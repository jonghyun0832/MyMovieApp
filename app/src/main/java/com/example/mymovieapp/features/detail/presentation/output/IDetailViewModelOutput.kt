package com.example.mymovieapp.features.detail.presentation.output

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface IDetailViewModelOutput {
    val detailState: StateFlow<MovieDetailState>
    val detailUiEffect: SharedFlow<DetailUiEffect>
}

sealed class DetailUiEffect {
    data object Back : DetailUiEffect()

    data class OpenUrl(
        val url: String
    ) : DetailUiEffect()

    data class RateMovie(
        val movieTitle: String,
        val rating: Float
    ) : DetailUiEffect()
}
