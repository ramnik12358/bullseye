package com.ramniksoftware.bullseye

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.ramniksoftware.bullseye.ui.theme.BullseyeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BullseyeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    GameScreen()
                }
            }
        }
    }
}

