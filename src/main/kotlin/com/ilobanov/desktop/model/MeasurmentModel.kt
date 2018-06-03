package com.ilobanov.desktop.model

import com.ilobanov.desktop.data.Measurment
import tornadofx.ItemViewModel

class MeasurmentModel : ItemViewModel<Measurment>() {

    val id = bind(Measurment::id)
    val name = bind(Measurment::name)

    override fun onCommit() {
        item = Measurment(
            id.value,
            name.value
        )
    }
}