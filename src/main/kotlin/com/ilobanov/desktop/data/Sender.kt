package com.ilobanov.desktop.data

import kotlinx.serialization.Serializable

/*
*
* */
@Serializable
class Sender(
    val id: Int? = null,
    val name: String,
    val sensor: Sensor?
)