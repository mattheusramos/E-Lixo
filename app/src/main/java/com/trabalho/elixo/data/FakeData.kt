package com.trabalho.elixo.data

import com.trabalho.elixo.R
val locations = listOf(
    LocationModel(
        nome = "ASMARE - Reciclagem Completa",
        descricao = "Cooperativa de Reciclagem",
        endereco = "Rua Ituiutaba, 888 - Prado, Belo Horizonte",
        latitude = -19.9240,
        longitude = -43.9550,
        icon = R.drawable.a4,
        itens = listOf(
            ItemReciclavel("Monitores", 5, icon = R.drawable.monitor),
            ItemReciclavel("Celulares", 10, icon = R.drawable.celular),
            ItemReciclavel("Notebooks", 17, icon = R.drawable.notebook),
            ItemReciclavel("Tablets", 6, icon = R.drawable.tabket)
        )
    ),

    LocationModel(
        nome = "BH Recicla - Centro",
        descricao = "Eletrônicos e Recicláveis",
        endereco = "Av. do Contorno, 8425 - Lourdes, Belo Horizonte",
        latitude = -19.9245,
        longitude = -43.9400,
        icon = R.drawable.a1,
        itens = listOf(
            ItemReciclavel("Gabinetes", 3, icon = R.drawable.gabinete),
            ItemReciclavel("GPUs", 4, icon = R.drawable.gpu),
            ItemReciclavel("Teclados", 14, icon = R.drawable.teclado),
            ItemReciclavel("Roteadores", 9, icon = R.drawable.roteador),
            ItemReciclavel("Celulares", 11, icon = R.drawable.celular)
        )
    ),

    LocationModel(
        nome = "Ecoponto Pampulha",
        descricao = "Entulho, móveis e eletrônicos",
        endereco = "Av. Antônio Carlos, 7594 - Pampulha, Belo Horizonte",
        latitude = -19.8690,
        longitude = -43.9700,
        icon = R.drawable.a2,
        itens = listOf(
            ItemReciclavel("TVs", 6, icon = R.drawable.tv),
            ItemReciclavel("Monitores", 4, icon = R.drawable.monitor),
            ItemReciclavel("Kit Teclado e Mouse", 10, icon = R.drawable.tecladoemouse),
            ItemReciclavel("Radios", 12, icon = R.drawable.radio),
            ItemReciclavel("Placa-mae", 3, icon = R.drawable.placamae),
            ItemReciclavel("PC Completo", 1, icon = R.drawable.pccompleto)
        )
    )
)