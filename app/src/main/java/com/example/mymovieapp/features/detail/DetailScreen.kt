package com.example.mymovieapp.features.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.example.mymovieapp.R
import com.example.mymovieapp.features.common.entity.MovieDetailEntity
import com.example.mymovieapp.features.detail.presentation.input.IDetailViewModelInput
import com.example.mymovieapp.features.detail.presentation.output.DetailUiEffect
import com.example.mymovieapp.features.detail.presentation.output.MovieDetailState
import com.example.mymovieapp.features.detail.presentation.viewmodel.MovieDetailViewModel
import com.example.mymovieapp.features.dialogs.IMDBDialogScreen
import com.example.mymovieapp.features.dialogs.RatingDialogScreen
import com.example.mymovieapp.features.feed.presentation.output.FeedUiEffect
import com.example.mymovieapp.ui.components.buttons.PrimaryButton
import com.example.mymovieapp.ui.components.buttons.SecondaryButton
import com.example.mymovieapp.ui.components.movie.MovieMeta
import com.example.mymovieapp.ui.theme.Paddings
import com.example.mymovieapp.ui.util.getAnnotatedText
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DetailScreen(
    movieName: String,
    navController: NavController,
    openUrl: (String) -> Unit,
    viewModel: MovieDetailViewModel = hiltViewModel()
) {
    var showRatingDialog by remember { mutableStateOf(false) }
    var ratingDialogTitle by remember { mutableStateOf("") }
    var ratingDialogScore by remember { mutableStateOf(0f) }

    var showIMDBDialog by remember { mutableStateOf(false) }
    var url by remember { mutableStateOf("") }

    LaunchedEffect(movieName) {
        viewModel.initMovieName(movieName)
    }

    LaunchedEffect(Unit) {
        viewModel.detailUiEffect.collectLatest { effect ->
            when (effect) {
                is DetailUiEffect.Back -> {
                    navController.navigateUp()
                }

                is DetailUiEffect.RateMovie -> {
                    showRatingDialog = true
                    ratingDialogTitle = effect.movieTitle
                    ratingDialogScore = effect.rating
                }

                is DetailUiEffect.OpenUrl -> {
                    showIMDBDialog = true
                    url = effect.url
                }
            }
        }
    }

    val movieDetail by viewModel.outputs.detailState.collectAsState()

    if (movieDetail is MovieDetailState.Main) {
        MovieDetail(
            movie = (movieDetail as MovieDetailState.Main).movieDetailEntity,
            input = viewModel.inputs
        )
    }

    if (showRatingDialog) {
        RatingDialogScreen(
            movieName = ratingDialogTitle,
            rating = ratingDialogScore,
            action = {},
            onDismiss = {
                showRatingDialog = false
            }
        )
    }

    if (showIMDBDialog) {
        IMDBDialogScreen(
            action = {
                openUrl(url)
            },
            onDismiss = {
                showIMDBDialog = false
            }
        )
    }

    BackHandler {
        viewModel.inputs.goBackToFeed()
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetail(
    movie: MovieDetailEntity,
    input: IDetailViewModelInput
) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                modifier = Modifier.requiredHeight(70.dp),
                navigationIcon = {
                    IconButton(onClick = { input.goBackToFeed() }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_back),
                            contentDescription = null
                        )
                    }
                },
//                colors = TopAppBarColors(
//                    containerColor = MaterialTheme.colorScheme.surface,
//                    scrolledContainerColor = MaterialTheme.colorScheme.surface,
//                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
//                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
//                    actionIconContentColor = MaterialTheme.colorScheme.surface
//                )
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = Paddings.extra
                )
                .scrollable(
                    state = scrollState,
                    orientation = Orientation.Vertical
                )
        ) {
            Row {
                // Poster
                BigPoster(
                    movie = movie
                )

                // Meta
                Column(
                    modifier = Modifier.padding(start = Paddings.xlarge)
                ) {
                    // Rating
                    MovieMeta(
                        key = "Rating",
                        value = movie.rating.toString()
                    )

                    // Director
                    MovieMeta(
                        key = "Director",
                        value = movie.directors.joinToString(separator = ", ")
                    )

                    // Starring
                    MovieMeta(
                        key = "Starring",
                        value = movie.actors.joinToString(separator = ", ")
                    )

                    // Genre
                    MovieMeta(
                        key = "Genre",
                        value = movie.genre.joinToString(separator = ", ")
                    )
                }
            }

            // Title
            Text(
                text = getAnnotatedText(text = movie.title),
                modifier = Modifier.padding(
                    top = Paddings.extra,
                    bottom = Paddings.large
                ),
                style = MaterialTheme.typography.displaySmall
            )

            // Desc
            Text(
                text = getAnnotatedText(text = movie.desc),
                modifier = Modifier.padding(
                    bottom = Paddings.xlarge
                ),
                style = MaterialTheme.typography.titleMedium
            )

            // Rating
            PrimaryButton(
                modifier = Modifier
                    .padding(top = Paddings.xlarge)
                    .fillMaxWidth(),
                text = "Add Rating Score",
                onClick = {
                    input.rateClicked()
                }
            )

            // IMDB Button
            SecondaryButton(
                modifier = Modifier
                    .padding(top = Paddings.xlarge)
                    .fillMaxWidth(),
                text = "OPEN IMDB",
                onClick = {
                    input.openImdbClicked()
                }
            )
        }
    }
}

@Composable
fun BigPoster(
    movie: MovieDetailEntity
) {
    Card {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest
                    .Builder(LocalContext.current)
                    .data(data = movie.thumbUrl)
                    .apply {
                        crossfade(true)
                        scale(Scale.FILL)
                    }.build()
            ),
            modifier = Modifier
                .width(180.dp)
                .height(250.dp),
            contentScale = ContentScale.FillHeight,
            contentDescription = "Movie Poster Image"
        )
    }
}
