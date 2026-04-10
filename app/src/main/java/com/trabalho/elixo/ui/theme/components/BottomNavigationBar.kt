package com.trabalho.elixo.ui.theme.components

import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.filled.*

@Composable
fun BottomNavigationBar(
    onSettingsClick: () -> Unit,
    onMonetizacaoClick: () -> Unit
) {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = { Icon(Icons.Default.LocationOn, contentDescription = null) }
        )

        NavigationBarItem(
            selected = false,
            onClick = onMonetizacaoClick,
            icon = { Icon(imageVector = Icons.Default.MonetizationOn, contentDescription = null) }
        )

        NavigationBarItem(
            selected = false,
            onClick = onSettingsClick,
            icon = { Icon(Icons.Default.Settings, contentDescription = null) }
        )
    }
}