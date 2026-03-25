package com.trabalho.elixo.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.trabalho.elixo.data.LocationModel
import com.trabalho.elixo.ui.theme.GreenLight
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.trabalho.elixo.ui.theme.GrayText
import com.trabalho.elixo.ui.theme.GreenPrimary
import com.trabalho.elixo.R

@Composable
fun LocationCard(location: LocationModel) {

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(GreenLight, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.recycle),
                    contentDescription = "Recycle"
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(location.nome, fontWeight = FontWeight.Bold)

                Text(
                    location.descricao,
                    color = GreenPrimary,
                    style = MaterialTheme.typography.bodySmall
                )

                Text(
                    location.endereco,
                    color = GrayText,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Text(
                location.distancia,
                color = GreenPrimary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}