package com.ilobanov.desktop.model

import com.ilobanov.desktop.data.ObjLvlOne
import com.ilobanov.desktop.data.ObjLvlTwo
import javafx.beans.property.SimpleObjectProperty
import tornadofx.ItemViewModel
import tornadofx.onChange

class ObjLvlOneModel : ItemViewModel<ObjLvlOne>() {

    val id = bind(ObjLvlOne::id)
    val name = bind(ObjLvlOne::name)
    val objLvlTwo = ObjLvlTwoModel()

    init {
        id.onChange {
            objLvlTwo.itemProperty.bind(SimpleObjectProperty<ObjLvlTwo>(item?.objLvlTwo))
        }
    }

    override fun onCommit() {
        objLvlTwo.commit()
        item = ObjLvlOne(
                id.value,
                name.value,
                objLvlTwo.item
        )
    }
}