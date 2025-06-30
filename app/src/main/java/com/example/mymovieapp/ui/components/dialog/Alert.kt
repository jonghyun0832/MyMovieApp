package com.example.mymovieapp.ui.components.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.mymovieapp.R
import com.example.mymovieapp.ui.models.dialog.DialogButton
import com.example.mymovieapp.ui.models.dialog.DialogContent
import com.example.mymovieapp.ui.models.dialog.DialogText
import com.example.mymovieapp.ui.models.dialog.DialogTitle

@Composable
fun DialogPopup.Alert(
    title: String,
    bodyText: String,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Header(title),
        dialogContent = DialogContent.Large(
            DialogText.Default(bodyText)
        ),
        buttons = buttons
    )
}