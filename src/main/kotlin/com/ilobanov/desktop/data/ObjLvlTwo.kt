package com.ilobanov.desktop.data

import kotlinx.serialization.Serializable

@Serializable
data class ObjLvlTwo(
    val id: Int,
    val name: String,
    val objLvlThreeMap: MutableMap<Int, ObjLvlThree>?
)