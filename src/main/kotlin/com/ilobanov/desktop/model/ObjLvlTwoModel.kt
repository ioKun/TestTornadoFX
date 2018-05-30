package com.ilobanov.desktop.model

import com.ilobanov.desktop.data.ObjLvlThree
import com.ilobanov.desktop.data.ObjLvlTwo
import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections
import tornadofx.ItemViewModel
import tornadofx.onChange

class ObjLvlTwoModel : ItemViewModel<ObjLvlTwo>() {

    val id = bind(ObjLvlTwo::id)
    val name = bind(ObjLvlTwo::name)
    val objLvlThreeList = FXCollections.observableArrayList<ObjLvlThreeModel>()!!

    init {
        prepare()
        id.onChange {
            if(!isPrepared) prepare()
        }
    }

    var isPrepared = false
    private fun prepare() {
        val sensorsMap = item?.objLvlThreeMap?: emptyMap<String, ObjLvlThree>()
        val list = sensorsMap.map {
            val sensorModel = ObjLvlThreeModel()
            sensorModel.itemProperty.bindBidirectional(SimpleObjectProperty<ObjLvlThree>(it.value))
            sensorModel
//                it.value
        }
        objLvlThreeList.setAll(list)
        isPrepared = list.isNotEmpty()
    }

    override fun onCommit() {
        objLvlThreeList.forEach { it.commit() }
        item = ObjLvlTwo(
            id.value,
            name.value,
            objLvlThreeList.map { it.id.value to it.item }.toMap().toMutableMap()
        )
    }
}