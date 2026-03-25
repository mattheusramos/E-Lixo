package com.trabalho.elixo.utils

import kotlin.math.*

object DistanceUtils {

    fun calcularDistancia(
        lat1: Double, lon1: Double,
        lat2: Double, lon2: Double
    ): String {

        val raioTerra = 6371.0 // km

        val dLat = Math.toRadians(lat2 - lat1)
        val dLon = Math.toRadians(lon2 - lon1)

        val a = sin(dLat / 2).pow(2) +
                cos(Math.toRadians(lat1)) *
                cos(Math.toRadians(lat2)) *
                sin(dLon / 2).pow(2)

        val c = 2 * atan2(sqrt(a), sqrt(1 - a))
        val distanciaKm = raioTerra * c

        return if (distanciaKm < 1) {
            "${(distanciaKm * 1000).toInt()} m"
        } else {
            "%.1f km".format(distanciaKm)
        }
    }
}