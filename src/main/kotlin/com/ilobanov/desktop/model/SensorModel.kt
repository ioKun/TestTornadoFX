package com.ilobanov.desktop.model

import com.ilobanov.desktop.data.Measurment
import com.ilobanov.desktop.data.Sensor
import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections
import tornadofx.ItemViewModel
import tornadofx.onChange

class SensorModel : ItemViewModel<Sensor>() {

    val id = bind(Sensor::id)
    val name = bind(Sensor::name)
    val objLvlThreeList = FXCollections.observableArrayList<MeasurmentModel>()!!

    init {
        prepare()
        id.onChange {
            if(!isPrepared) prepare()
        }
    }

    var isPrepared = false
    private fun prepare() {
        val sensorsMap = item?.measurmentMap?: emptyMap<String, Measurment>()
        val list = sensorsMap.map {
            val sensorModel = MeasurmentModel()
            sensorModel.itemProperty.bindBidirectional(SimpleObjectProperty<Measurment>(it.value))
            sensorModel
//                it.value
        }
        objLvlThreeList.setAll(list)
        isPrepared = list.isNotEmpty()
    }

    override fun onCommit() {
        objLvlThreeList.forEach { it.commit() }
        item = Sensor(
            id.value,
            name.value,
            objLvlThreeList.map { it.id.value to it.item }.toMap().toMutableMap()
        )
    }
}