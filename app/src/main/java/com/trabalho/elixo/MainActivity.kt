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
import com.trabalho.elixo.ui.theme.screens.ReciclagemScreen
import com.trabalho.elixo.ui.theme.screens.MonetizacaoScreen
import com.trabalho.elixo.ui.theme.screens.LoginScreen
import com.trabalho.elixo.data.LocationModel
import com.trabalho.elixo.ui.theme.screens.DetailScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var isDarkMode by remember { mutableStateOf(false) }
            var selectedLocation by remember { mutableStateOf<LocationModel?>(null) }
            var currentScreen by remember { mutableStateOf("login") }

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
                        },

                        onNavigateToReciclagem = {
                            currentScreen = "reciclagem"
                        },

                        onLocationClick = { location ->
                            selectedLocation = location
                            currentScreen = "detalhes"
                        },

                        onNavigateToMonetizacao = {
                            currentScreen = "monetizacao"
                        },

                        onLogout = {
                            currentScreen = "login"
                        }
                    )

                    "settings" -> SettingsScreen(
                        onBack = {
                            currentScreen = "home"
                        },
                        isDarkMode = isDarkMode,
                        onThemeChange = { isDarkMode = it }
                    )

                    "reciclagem" -> ReciclagemScreen(
                        onBack = {
                            currentScreen = "home"
                        }
                    )

                    "monetizacao" -> MonetizacaoScreen(
                        onBack = {
                            currentScreen = "home"
                        }
                    )

                    "login" -> LoginScreen(
                        onLogin = {
                            currentScreen = "home"
                        }
                    )

                    "detalhes" -> selectedLocation?.let { location ->
                        DetailScreen(
                            location = location,
                            onBack = {
                                currentScreen = "home"
                            }
                        )
                    }
                }
            }
        }
    }
}