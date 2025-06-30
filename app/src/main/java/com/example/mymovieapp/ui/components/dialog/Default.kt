package com.example.mymovieapp.ui.components.dialog

import androidx.compose.runtime.Composable
import com.example.mymovieapp.ui.models.dialog.DialogButton
import com.example.mymovieapp.ui.models.dialog.DialogContent
import com.example.mymovieapp.ui.models.dialog.DialogText
import com.example.mymovieapp.ui.models.dialog.DialogTitle

object DialogPopup

@Composable
fun DialogPopup.Default(
    title: String,
    bodyText: String,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Default(title),
        dialogContent = DialogContent.Default(
            DialogText.Default(bodyText)
        ),
        buttons = buttons
    )
}