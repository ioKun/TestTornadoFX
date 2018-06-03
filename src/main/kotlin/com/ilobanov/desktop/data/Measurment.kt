package com.ilobanov.desktop.data

import com.sun.xml.internal.ws.developer.Serialization
import kotlinx.serialization.Serializable

@Serializable
data class Measurment(
    val id: Int? = null,
    val name: String
)