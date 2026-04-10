package com.trabalho.elixo.data

import androidx.annotation.DrawableRes

data class ItemReciclavel(
    val nomeObjeto: String,
    val quantidade: Int,
    @DrawableRes val icon: Int
)
data class LocationModel(
    val nome: String,
    val descricao: String,
    val endereco: String,
    val latitude: Double,
    val longitude: Double,
    var distancia: String = "",
    val itens: List<ItemReciclavel>,
    @DrawableRes val icon: Int
)