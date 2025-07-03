package com.example.mymovieapp.features.dialogs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Dialog

@Composable
fun ControlledDismissDialog(
    onDismiss: () -> Unit,
    content: @Composable () -> Unit
) {
    var dismissed by remember { mutableStateOf(false) }

    if (dismissed) {
        LaunchedEffect(Unit) {
            onDismiss()
        }
    }

    Dialog(
        onDismissRequest = {
            if (!dismissed) dismissed = true
        }
    ) {
        content()
    }
}