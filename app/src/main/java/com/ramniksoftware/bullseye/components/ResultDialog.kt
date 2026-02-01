package com.ramniksoftware.bullseye.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.res.stringResource

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramniksoftware.bullseye.R

@Composable
fun ResultDialog(
    hideDialog: () -> Unit,
    onRoundIncrement: () -> Unit,
    sliderValue: Int,
    points: Int,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            hideDialog()
            onRoundIncrement()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    hideDialog()
                    onRoundIncrement()
                }
            ) {
                Text(stringResource(R.string.result_dialog_button_text))
            }
        },
        title = {Text(stringResource(R.string.result_dialog_title))},
        text = { Text(stringResource(R.string.result_dialog_message, sliderValue, points))}
    )
}