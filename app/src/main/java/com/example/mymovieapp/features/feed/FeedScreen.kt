package com.example.mymovieapp.features.feed

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mymovieapp.features.feed.presentation.viewmodel.FeedViewModel

@Composable
fun FeedScreen(
    viewModel: FeedViewModel = hiltViewModel()
) {
    Text("Feed Fragment (Compose Screen)")
}