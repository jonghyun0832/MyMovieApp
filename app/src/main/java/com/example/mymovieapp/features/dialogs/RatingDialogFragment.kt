package com.example.mymovieapp.features.dialogs

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.mymovieapp.R
import com.example.mymovieapp.ui.components.dialog.DialogPopup
import com.example.mymovieapp.ui.components.dialog.Rating
import com.example.mymovieapp.ui.models.buttons.LeadingIconData
import com.example.mymovieapp.ui.models.dialog.DialogButton

@Composable
fun RatingDialogScreen(
    movieName: String,
    rating: Float,
    action: () -> Unit,
    onDismiss: () -> Unit
) {
    ControlledDismissDialog(
        onDismiss = onDismiss
    ) {
        DialogPopup.Rating(
            movieName = movieName,
            rating = rating,
            buttons = listOf(
                DialogButton.Primary(
                    title = stringResource(R.string.submit),
                    leadingIconData = LeadingIconData(
                        iconDrawable = R.drawable.ic_send,
                        iconContentDescription = R.string.submit
                    )
                ) {
                    action()
                    onDismiss()
                },
                DialogButton.Secondary(stringResource(R.string.cancel)) {
                    onDismiss()
                }
            )
        )
    }
}