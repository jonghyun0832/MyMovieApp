package com.example.mymovieapp.features.feed.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovieapp.features.common.entity.EntityWrapper
import com.example.mymovieapp.features.common.repository.IMovieDataSource
import com.example.mymovieapp.features.feed.domain.useacse.IGetFeedCategoryUseCase
import com.example.mymovieapp.features.feed.presentation.input.IFeedViewModelInput
import com.example.mymovieapp.features.feed.presentation.output.FeedState
import com.example.mymovieapp.features.feed.presentation.output.FeedUiEffect
import com.example.mymovieapp.features.feed.presentation.output.IFeedViewModelOutput
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val getFeedCategoryUseCase: IGetFeedCategoryUseCase
): ViewModel(), IFeedViewModelOutput, IFeedViewModelInput {

    val output: IFeedViewModelOutput = this
    val input: IFeedViewModelInput = this

    // 화면에 보여주기 위한 Flow
    private val _feedState: MutableStateFlow<FeedState> = MutableStateFlow(FeedState.Loading)
    override val feedState: StateFlow<FeedState> get() = _feedState

    private val _feedInfoDialogState: MutableStateFlow<Boolean> =
        MutableStateFlow(false)
    override val feedInfoDialogState: StateFlow<Boolean>
        get() = _feedInfoDialogState

    // 유저로부터 입력을 받아서 Fragment단에서 액션을 수행하기 위한 Flow
    private val _feedUiEffect = MutableSharedFlow<FeedUiEffect>(replay = 0)
    override val feedUiEffect: SharedFlow<FeedUiEffect> get() = _feedUiEffect

    init {
        fetchFeed()
    }

    private fun fetchFeed() {
        viewModelScope.launch {
            _feedState.value = FeedState.Loading

            val categories = getFeedCategoryUseCase()
            _feedState.value = when (categories) {
                is EntityWrapper.Success -> {
                    FeedState.Main(
                        categories = categories.entity
                    )
                }
                is EntityWrapper.Fail -> {
                    FeedState.Failed(
                        reason = categories.error.message ?: ""
                    )
                }
            }
        }
    }

    fun dismissInfoDialog() {
        _feedInfoDialogState.value = false
    }

    override fun openDetail(movieName: String) {
        viewModelScope.launch {
            _feedUiEffect.emit(
                FeedUiEffect.OpenMovieDetail(movieName)
            )
        }
    }

    override fun openInfoDialog() {
        _feedInfoDialogState.value = true
    }

    override fun refreshFeed() {
        TODO("Not yet implemented")
    }
}