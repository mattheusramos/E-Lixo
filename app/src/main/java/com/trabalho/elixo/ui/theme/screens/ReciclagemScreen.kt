package com.trabalho.elixo.ui.theme.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class MaterialReciclagem(
    val titulo: String,
    val icone: String,
    val cor: Color,
    val status: String,
    val descricao: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReciclagemScreen(onBack: () -> Unit) {

    val materiais = listOf(
        MaterialReciclagem(
            titulo = "Eletrônicos",
            icone = "💻",
            cor = Color(0xFF455A64),
            status = "⚠️ Material complicado",
            descricao = "Celulares, computadores, fios, teclados e aparelhos eletrônicos devem ir para coleta especializada de lixo eletrônico."
        ),
        MaterialReciclagem(
            titulo = "Papel",
            icone = "📄",
            cor = Color(0xFF2F578B),
            status = "✅ Material reciclável",
            descricao = "Jornais, revistas, folhas, caixas de papelão e outros papéis limpos e secos."
        ),
        MaterialReciclagem(
            titulo = "Plástico",
            icone = "🧴",
            cor = Color(0xFFD50000),
            status = "✅ Material reciclável",
            descricao = "Garrafas PET, embalagens plásticas, potes, sacolas e recipientes plásticos limpos."
        ),
        MaterialReciclagem(
            titulo = "Vidro",
            icone = "🍾",
            cor = Color(0xFF1E7A3E),
            status = "✅ Material reciclável",
            descricao = "Garrafas, frascos e potes de vidro. Evite misturar com espelhos, porcelanas e cerâmicas."
        ),
        MaterialReciclagem(
            titulo = "Metal",
            icone = "🥫",
            cor = Color(0xFFF2C300),
            status = "✅ Material reciclável",
            descricao = "Latas de alumínio, latas de aço, tampas metálicas e embalagens metálicas limpas."
        ),
        MaterialReciclagem(
            titulo = "Orgânico",
            icone = "🍎",
            cor = Color(0xFFA65E2E),
            status = "⚠️ Material complicado",
            descricao = "Restos de alimentos, cascas de frutas, legumes e resíduos naturais. O descarte ideal pode envolver compostagem."
        ),
        MaterialReciclagem(
            titulo = "Resíduos perigosos",
            icone = "☠️",
            cor = Color(0xFF6A1B9A),
            status = "⚠️ Material complicado",
            descricao = "Pilhas, baterias, lâmpadas, produtos químicos, tintas e solventes exigem descarte específico."
        ),
        MaterialReciclagem(
            titulo = "Entulho",
            icone = "🧱",
            cor = Color(0xFF616161),
            status = "⚠️ Material complicado",
            descricao = "Restos de construção, concreto, tijolos, telhas e outros resíduos de obra precisam de local adequado para descarte."
        ),
        MaterialReciclagem(
            titulo = "Madeira",
            icone = "🪵",
            cor = Color(0xFF8D6E63),
            status = "✅ Material reciclável",
            descricao = "Pedaços de madeira, pallets e sobras sem contaminação podem ser reaproveitados ou reciclados."
        ),
        MaterialReciclagem(
            titulo = "Móveis",
            icone = "🪑",
            cor = Color(0xFF795548),
            status = "⚠️ Material complicado",
            descricao = "Móveis velhos podem ser reaproveitados, doados, desmontados ou levados a ecopontos específicos."
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Aprenda a Reciclar") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(materiais.size) { index ->
                val material = materiais[index]

                CardExpansivelReciclagem(
                    titulo = material.titulo,
                    icone = material.icone,
                    cor = material.cor,
                    status = material.status,
                    conteudo = material.descricao
                )
            }
        }
    }
}

@Composable
fun CardExpansivelReciclagem(
    titulo: String,
    icone: String,
    cor: Color,
    status: String,
    conteudo: String
) {
    var expandido by remember { mutableStateOf(false) }

    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expandido = !expandido },
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = cor),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp, vertical = 18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = icone,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(end = 10.dp)
                )

                Text(
                    text = titulo,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = if (expandido) "▲" else "▼",
                    color = Color.White,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }

        AnimatedVisibility(visible = expandido) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                shape = RoundedCornerShape(14.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = status,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = conteudo,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}