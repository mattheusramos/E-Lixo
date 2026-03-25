package com.trabalho.elixo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.trabalho.elixo.ui.theme.screens.HomeScreen
import com.trabalho.elixo.ui.theme.screens.SettingsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var currentScreen by remember { mutableStateOf("home") }

            when (currentScreen) {

                "home" -> HomeScreen(
                    onNavigateToSettings = {
                        currentScreen = "settings"
                    }
                )

                "settings" -> SettingsScreen(
                    onBack = {
                        currentScreen = "home"
                    }
                )
            }
        }
    }
}