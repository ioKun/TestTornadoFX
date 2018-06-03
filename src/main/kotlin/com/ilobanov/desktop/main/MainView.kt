package com.ilobanov.desktop.main

import com.ilobanov.desktop.data.Sender
import com.ilobanov.desktop.data.Measurment
import com.ilobanov.desktop.data.Sensor
import javafx.collections.FXCollections
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import tornadofx.*

class MainView : View(null, null) {

    private val dataList = FXCollections.observableArrayList<Sender>()!!

    init {
        async {
            delay(500)
            showData()
        }
    }

    override val root = vbox {
        listview(dataList) {
            style {
                prefWidth = 500.px
            }
            cellFragment(ObjCardFragment::class)
        }
    }

    fun showData() {
        val list = List(5) {
            Sender(
                it,
                "LvlOneName $it",
                Sensor(
                    it * 2 + 1,
                    "LvlTwoName ${it*2}",
                    mutableMapOf(
                        it*2 to Measurment(it*3, "LvlThreeName ${it*3}"),
                        it*3 to Measurment(it*4, "LvlThreeName ${it*4}")
                    )
                )
            )
        }
        list.forEach {
            println(it.sensor?.measurmentMap?.size)
        }
        dataList.setAll(list)
    }
}