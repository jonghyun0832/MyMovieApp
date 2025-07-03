package com.example.mymovieapp.features.dialogs

import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mymovieapp.R
import com.example.mymovieapp.ui.components.dialog.Default
import com.example.mymovieapp.ui.components.dialog.DialogPopup
import com.example.mymovieapp.ui.models.dialog.DialogButton
import com.example.mymovieapp.ui.theme.MyMovieAppTheme

@Composable
fun IMDBDialogScreen(
    action: () -> Unit,
    onDismiss: () -> Unit
) {

//    val themeViewModel: ThemeViewModel = hiltViewModel()
    ControlledDismissDialog(onDismiss) {
        DialogPopup.Default(
            title = stringResource(R.string.imdb_title),
            bodyText = stringResource(R.string.imdb_message),
            buttons = listOf(
                DialogButton.Primary(stringResource(R.string.open)) {
                    action()
                    onDismiss()
                },
                DialogButton.SecondaryBorderless(stringResource(R.string.cancel)) {
                    onDismiss()
                }
            )
        )
    }
}
