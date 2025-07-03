package com.example.mymovieapp.features.detail.presentation.output

import com.example.mymovieapp.features.detail.presentation.model.IMDBDialogState
import com.example.mymovieapp.features.detail.presentation.model.RatingDialogState
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface IDetailViewModelOutput {
    val detailState: StateFlow<MovieDetailState>
    val detailUiEffect: SharedFlow<DetailUiEffect>
    val imdbDialogState: StateFlow<IMDBDialogState?>
    val ratingDialogState: StateFlow<RatingDialogState?>
}

sealed class DetailUiEffect {
    data object Back : DetailUiEffect()
}
