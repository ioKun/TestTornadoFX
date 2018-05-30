package com.ilobanov.desktop.data

import kotlinx.serialization.Serializable

@Serializable
class ObjLvlOne(
    val id: Int? = null,
    val name: String,
    val objLvlTwo: ObjLvlTwo?
)