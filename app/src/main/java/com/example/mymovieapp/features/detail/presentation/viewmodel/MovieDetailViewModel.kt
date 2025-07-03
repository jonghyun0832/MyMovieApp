package com.example.mymovieapp.features.detail.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovieapp.features.detail.domain.usecase.IGetMovieDetailUseCase
import com.example.mymovieapp.features.detail.presentation.input.IDetailViewModelInput
import com.example.mymovieapp.features.detail.presentation.output.IMDBDialogState
import com.example.mymovieapp.features.detail.presentation.output.RatingDialogState
import com.example.mymovieapp.features.detail.presentation.output.DetailUiEffect
import com.example.mymovieapp.features.detail.presentation.output.IDetailViewModelOutput
import com.example.mymovieapp.features.detail.presentation.output.MovieDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: IGetMovieDetailUseCase
) : ViewModel(), IDetailViewModelInput, IDetailViewModelOutput {

    val inputs: IDetailViewModelInput = this
    val outputs: IDetailViewModelOutput = this

    private val _detailState: MutableStateFlow<MovieDetailState> =
        MutableStateFlow(MovieDetailState.Initial)
    override val detailState: StateFlow<MovieDetailState>
        get() = _detailState

    private val _imdbDialogState: MutableStateFlow<IMDBDialogState?> =
        MutableStateFlow(null)
    override val imdbDialogState: StateFlow<IMDBDialogState?>
        get() = _imdbDialogState

    private val _ratingDialogState: MutableStateFlow<RatingDialogState?> =
        MutableStateFlow(null)
    override val ratingDialogState: StateFlow<RatingDialogState?>
        get() = _ratingDialogState

    private val _detailUiEffect = MutableSharedFlow<DetailUiEffect>(replay = 0)
    override val detailUiEffect: SharedFlow<DetailUiEffect>
        get() = _detailUiEffect

//    private val _showRatingDialog = MutableStateFlow<RatingDialogState?>(null)
//    val showRatingDialog: StateFlow<RatingDialogState?> = _showRatingDialog
//
//    private val _showIMDBDialog = MutableStateFlow<IMDBDialogState?>(null)
//    val showIMDBDialog: StateFlow<IMDBDialogState?> = _showIMDBDialog

    suspend fun initMovieName(movieName: String) {
        _detailState.value = MovieDetailState.Main(
            movieDetailEntity = getMovieDetailUseCase(movieName)
        )
    }

    override fun goBackToFeed() {
        viewModelScope.launch {
            _detailUiEffect.emit(
                DetailUiEffect.Back
            )
        }
    }

    override fun openImdbClicked() {
        viewModelScope.launch {
            if (detailState.value is MovieDetailState.Main) {
                val value = detailState.value as MovieDetailState.Main
                _imdbDialogState.value = IMDBDialogState(
                    url = value.movieDetailEntity.imdbPath
                )
            }
        }
    }

    override fun rateClicked() {
        viewModelScope.launch {
            if (detailState.value is MovieDetailState.Main) {
                val value = detailState.value as MovieDetailState.Main
                _ratingDialogState.value = RatingDialogState(
                    movieTitle = value.movieDetailEntity.title,
                    rating = value.movieDetailEntity.rating
                )
            }
        }
    }

    fun dismissImdbDialog() {
        _imdbDialogState.value = null
    }

    fun dismissRatingDialog() {
        _ratingDialogState.value = null
    }
}