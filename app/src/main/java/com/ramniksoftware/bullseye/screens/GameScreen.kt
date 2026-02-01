package com.ramniksoftware.bullseye.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices.AUTOMOTIVE_1024p
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramniksoftware.bullseye.R
import com.ramniksoftware.bullseye.components.GameDetail
import com.ramniksoftware.bullseye.components.GamePrompt
import com.ramniksoftware.bullseye.components.ResultDialog
import com.ramniksoftware.bullseye.components.TargetSlider
import com.ramniksoftware.bullseye.ui.theme.BullseyeTheme
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

@Composable
fun GameScreen() {
    var alertIsVisible by rememberSaveable { mutableStateOf(false) }
    var sliderValue by rememberSaveable { mutableStateOf(0.5f)}
    var targetValue by rememberSaveable { mutableStateOf(Random.nextInt(1, 100))}

    val sliderInt = (sliderValue * 100).toInt()

    fun pointsForCurrentRound(): Int {
        return max(sliderInt, targetValue) - min(sliderInt, targetValue)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.weight(.5f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.weight(9f)
        ) {
            GamePrompt(targetValue = targetValue)
            TargetSlider(
                value = sliderValue,
                onValueChange = { value ->
                    sliderValue = value
                }
            )
            Button(onClick = {
                alertIsVisible = true
            }) {
                Text(stringResource(R.string.hit_me_button_text))
            }
            GameDetail(modifier = Modifier.fillMaxWidth())
        }
        Spacer(modifier = Modifier.weight(.5f))

        if (alertIsVisible) {
            ResultDialog(
                hideDialog = { alertIsVisible = false },
                sliderValue = sliderInt,
                points = pointsForCurrentRound()
            )
        }
    }
}

@Preview(showBackground = true, device = AUTOMOTIVE_1024p, widthDp = 864, heightDp = 432)
@Composable
fun GameScreenPreview() {
    BullseyeTheme {
        GameScreen()
    }
}