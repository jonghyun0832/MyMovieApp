package com.example.mymovieapp.features.detail.presentation.output

data class RatingDialogState(
    val movieTitle: String,
    val rating: Float
)

data class IMDBDialogState(
    val url: String
)