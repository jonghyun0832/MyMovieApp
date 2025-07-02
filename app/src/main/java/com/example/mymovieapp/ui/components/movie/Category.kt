package com.example.mymovieapp.ui.components.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mymovieapp.features.common.entity.CategoryEntity
import com.example.mymovieapp.features.feed.presentation.input.IFeedViewModelInput
import com.example.mymovieapp.ui.theme.MyMovieAppTheme
import com.example.mymovieapp.ui.theme.Paddings

@Composable
fun CategoryRow(
    categoryEntity: CategoryEntity,
    input: IFeedViewModelInput
) {
    Column {
        CategoryTitle(categoryEntity.genre)
        LazyRow(
            contentPadding = PaddingValues(
                horizontal = Paddings.large
            )
        ) {
            itemsIndexed(categoryEntity.movieFeedEntities) { _, item ->
                MovieItem(
                    movie = item,
                    input = input
                )
            }
        }
    }
}

@Composable
fun CategoryTitle(s: String) {
    Text(
        text = s,
        modifier = Modifier
            .padding(
                vertical = Paddings.large,
                horizontal = Paddings.extra
            ),
        style = MaterialTheme.typography.headlineMedium
    )
}