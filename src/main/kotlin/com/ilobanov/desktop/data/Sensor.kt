package com.ilobanov.desktop.data

import kotlinx.serialization.Serializable

@Serializable
data class Sensor(
    val id: Int,
    val name: String,
    val measurmentMap: MutableMap<Int, Measurment>?
)