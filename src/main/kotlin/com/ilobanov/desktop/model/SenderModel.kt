package com.ilobanov.desktop.model

import com.ilobanov.desktop.data.Sender
import com.ilobanov.desktop.data.Sensor
import javafx.beans.property.SimpleObjectProperty
import tornadofx.ItemViewModel
import tornadofx.onChange

class SenderModel : ItemViewModel<Sender>() {

    val id = bind(Sender::id)
    val name = bind(Sender::name)
    val objLvlTwo = SensorModel()

    init {
        id.onChange {
            objLvlTwo.itemProperty.bind(SimpleObjectProperty<Sensor>(item?.sensor))
        }
    }

    override fun onCommit() {
        objLvlTwo.commit()
        item = Sender(
                id.value,
                name.value,
                objLvlTwo.item
        )
    }
}