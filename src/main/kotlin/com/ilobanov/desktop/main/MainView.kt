package com.ilobanov.desktop.main

import com.ilobanov.desktop.data.ObjLvlOne
import com.ilobanov.desktop.data.ObjLvlThree
import com.ilobanov.desktop.data.ObjLvlTwo
import javafx.collections.FXCollections
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import tornadofx.*
import java.util.*

class MainView : View(null, null) {

    private val dataList = FXCollections.observableArrayList<ObjLvlOne>()!!

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
            ObjLvlOne(
                it,
                "LvlOneName $it",
                ObjLvlTwo(
                    it * 2 + 1,
                    "LvlTwoName ${it*2}",
                    mutableMapOf(
                        it*2 to ObjLvlThree(it*3, "LvlThreeName ${it*3}"),
                        it*3 to ObjLvlThree(it*4, "LvlThreeName ${it*4}")
                    )
                )
            )
        }
        list.forEach {
            println(it.objLvlTwo?.objLvlThreeMap?.size)
        }
        dataList.setAll(list)
    }
}