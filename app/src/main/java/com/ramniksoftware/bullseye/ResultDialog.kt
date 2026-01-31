package com.ramniksoftware.bullseye

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.res.stringResource

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ResultDialog(
    hideDialog: () -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        onDismissRequest = {
            hideDialog()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    hideDialog()
                }
            ) {
                Text(stringResource(R.string.result_dialog_button_text))
            }
        },
        title = {Text(stringResource(R.string.result_dialog_title))},
        text = { Text(stringResource(R.string.result_dialog_message))}
    )
}