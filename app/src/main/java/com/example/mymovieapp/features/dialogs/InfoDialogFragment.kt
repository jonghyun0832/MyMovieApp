package com.example.mymovieapp.features.dialogs

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.stringResource
import com.example.mymovieapp.R
import com.example.mymovieapp.ui.components.dialog.Alert
import com.example.mymovieapp.ui.components.dialog.DialogPopup
import com.example.mymovieapp.ui.models.dialog.DialogButton
import dagger.hilt.android.AndroidEntryPoint

@Composable
fun InfoDialogScreen(
    onDismiss: () -> Unit
) {
    ControlledDismissDialog(onDismiss) {
        DialogPopup.Alert(
            title = stringResource(R.string.app_name),
            bodyText = stringResource(R.string.info_message),
            buttons = listOf(
                DialogButton.UnderlinedText(stringResource(R.string.close)) {
                    onDismiss()
                }
            )
        )
    }
}