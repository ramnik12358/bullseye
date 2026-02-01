package com.ramniksoftware.bullseye

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ramniksoftware.bullseye.screens.AboutScreen
import com.ramniksoftware.bullseye.screens.GameScreen
import com.ramniksoftware.bullseye.ui.theme.BullseyeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BullseyeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { contentPadding ->
                    MainScreen(modifier = Modifier.padding(contentPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "game-screen") {
        composable("game-screen") {
            GameScreen(
                modifier = modifier,
                onAboutClicked = {
                    navController.navigate("about")
                })
        }
        composable("about") {
            AboutScreen(
                modifier = modifier,
                onNavigateBack = { navController.navigateUp() })
        }
    }
}

