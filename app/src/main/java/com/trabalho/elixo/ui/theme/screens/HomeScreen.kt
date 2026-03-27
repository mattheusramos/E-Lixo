package com.trabalho.elixo.ui.theme.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.trabalho.elixo.utils.LocationUtils
import com.trabalho.elixo.utils.DistanceUtils
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.trabalho.elixo.data.locations
import com.trabalho.elixo.ui.theme.GreenPrimary
import com.trabalho.elixo.ui.theme.components.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.getValue
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Alignment
import com.trabalho.elixo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onNavigateToSettings: () -> Unit)
{

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = {}
    )

    LaunchedEffect(Unit) {
        permissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
    }

    val context = LocalContext.current
    val locationUtils = LocationUtils(context)

    var userLat by remember { mutableStateOf<Double?>(null) }
    var userLon by remember { mutableStateOf<Double?>(null) }

    val updatedLocations = remember(userLat, userLon) {
        if (userLat != null && userLon != null)
        {
            locations.map {
                it.copy(
                    distancia = DistanceUtils.calcularDistancia(
                        userLat!!,
                        userLon!!,
                        it.latitude,
                        it.longitude
                    )
                )
            }
        }
        else locations
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Image(
                            painter = painterResource(id = R.drawable.app_icon),
                            contentDescription = "Logo",
                            modifier = Modifier.size(28.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text("E-lixo")
                    }
                },

                actions = {
                    IconButton(onClick = { /* atualizar */ }) {
                        Icon(Icons.Default.Refresh, contentDescription = "Atualizar")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(onSettingsClick = onNavigateToSettings)
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            Text(
                "Pontos de Coleta Próximos",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            SearchBar()

            LazyColumn {
                items(updatedLocations) { location ->
                    LocationCard(location)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    locationUtils.getCurrentLocation { lat, lon ->
                        userLat = lat
                        userLon = lon
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary)
            ) {
                Text("Atualizar localização")
            }
        }
    }
}