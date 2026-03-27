package com.trabalho.elixo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import com.trabalho.elixo.ui.theme.screens.HomeScreen
import com.trabalho.elixo.ui.theme.screens.SettingsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var currentScreen by remember { mutableStateOf("home") }
            var isDarkMode by remember { mutableStateOf(false) }

            val colorScheme = if (isDarkMode) {
                darkColorScheme()
            } else {
                lightColorScheme()
            }

            MaterialTheme(
                colorScheme = colorScheme
            ) {
                when (currentScreen) {

                    "home" -> HomeScreen(
                        onNavigateToSettings = {
                            currentScreen = "settings"
                        }
                    )

                    "settings" -> SettingsScreen(
                        onBack = {
                            currentScreen = "home"
                        },
                        isDarkMode = isDarkMode,
                        onThemeChange = { isDarkMode = it }
                    )
                }
            }

        }
    }
}