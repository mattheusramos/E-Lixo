package com.trabalho.elixo.data

data class LocationModel(
    val nome: String,
    val descricao: String,
    val endereco: String,
    val latitude: Double,
    val longitude: Double,
    var distancia: String = ""
)