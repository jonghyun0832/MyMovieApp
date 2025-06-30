package com.example.mymovieapp.ui.components.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mymovieapp.R
import com.example.mymovieapp.ui.models.buttons.LeadingIconData
import com.example.mymovieapp.ui.models.dialog.DialogButton
import com.example.mymovieapp.ui.theme.MyMovieAppTheme

@Preview
@Composable
fun AlertPreview() {
    MyMovieAppTheme {
        DialogPopup.Alert(
            title = "title",
            bodyText = "blah blah",
            buttons = listOf(
                DialogButton.Primary("okay") {},
                DialogButton.UnderlinedText("cancel") {}
            )
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyMovieAppTheme {
        DialogPopup.Default(
            title = "title",
            bodyText = "blah blah",
            buttons = listOf(
                DialogButton.Primary("OPEN") {},
                DialogButton.SecondaryBorderless("CANCEL") {}
            )
        )
    }
}

@Preview
@Composable
fun RatingPreview() {
    MyMovieAppTheme {
        DialogPopup.Rating(
            movieName = "title",
            rating = 7.5f,
            buttons = listOf(
                DialogButton.Primary(
                    title = "SUBMIT",
                    leadingIconData = LeadingIconData(
                        iconDrawable = R.drawable.ic_send,
                        iconContentDescription = null
                    )
                ) {},
                DialogButton.SecondaryBorderless("CANCEL") {}
            )
        )
    }
}