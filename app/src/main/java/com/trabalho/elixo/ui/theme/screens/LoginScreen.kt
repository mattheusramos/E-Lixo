package com.trabalho.elixo.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.trabalho.elixo.R
import com.trabalho.elixo.ui.theme.GreenPrimary
import com.trabalho.elixo.ui.theme.White
import com.trabalho.elixo.utils.MaskUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onLogin: () -> Unit
) {

    var usuario by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var senhaVisivel by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var showSuccessDialog by remember { mutableStateOf(false) }
    var telefone by remember { mutableStateOf("") }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // LOGO
            Image(
                painter = painterResource(id = R.drawable.app_icon),
                contentDescription = "Logo",
                modifier = Modifier.size(140.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "TechCycle",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(32.dp))

            // usuario
            OutlinedTextField(
                value = usuario,
                onValueChange = { usuario = it },
                label = { Text("Usuário") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // SENHA
            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                label = { Text("Senha") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                visualTransformation = if (senhaVisivel) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { senhaVisivel = !senhaVisivel }) {
                        Icon(
                            imageVector = if (senhaVisivel)
                                Icons.Default.Visibility
                            else
                                Icons.Default.VisibilityOff,
                            contentDescription = "Mostrar senha"
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // BOTÃO LOGIN
            Button(
                onClick = {
                    onLogin()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = GreenPrimary
                )
            ) {
                Text("Entrar", color = White)
            }

            Spacer(modifier = Modifier.height(12.dp))

            TextButton(
                onClick = { showDialog = true}
            ) {
                Text("Esqueceu sua senha?", color = GreenPrimary)
            }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    confirmButton = {
                        Button(
                            onClick = {
                                showDialog = false
                                showSuccessDialog = true
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary)
                        ) {
                            Text("Confirmar", color = White)
                        }
                    },
                    dismissButton = {
                        OutlinedButton(
                            onClick = { showDialog = false }
                        ) {
                            Text("Cancelar", color = GreenPrimary)
                        }
                    },
                    title = {
                        Text("Recuperar senha")
                    },
                    text = {
                        Column {
                            Text("Digite seu número de telefone")

                            Spacer(modifier = Modifier.height(12.dp))

                            OutlinedTextField(
                                value = telefone,
                                onValueChange = { telefone = MaskUtils.formatarTelefone(it) },
                                label = { Text("Telefone") },
                                placeholder = { Text("(00) 00000-0000") },
                                singleLine = true
                            )
                        }
                    }
                )
            }

            if (showSuccessDialog) {
                AlertDialog(
                    onDismissRequest = { showSuccessDialog = false },
                    confirmButton = {
                        Button(onClick = { showSuccessDialog = false },
                                colors = ButtonDefaults.buttonColors(
                                containerColor = GreenPrimary
                                )
                        ) {
                            Text("OK" , color = White)
                        }
                    },
                    title = {
                        Text("Sucesso!")
                    },
                    text = {
                        Text("Chegará um SMS com o link para atualizar sua senha.")
                    }
                )
            }
        }
    }
}