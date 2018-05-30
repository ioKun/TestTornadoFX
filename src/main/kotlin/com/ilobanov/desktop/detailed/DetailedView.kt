package com.ilobanov.desktop.detailed

import com.ilobanov.desktop.data.ObjLvlOne
import com.ilobanov.desktop.data.ObjLvlThree
import com.ilobanov.desktop.data.ObjLvlTwo
import com.ilobanov.desktop.main.ObjCardFragment
import com.ilobanov.desktop.model.ObjLvlOneModel
import javafx.collections.FXCollections
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import tornadofx.*

class DetailedView: View(null, null) {

    private val obj: ObjLvlOneModel by inject()

    override val root = vbox {
        form {
            fieldset("Data") {
                field("Lvl One Name") { textfield(obj.name) }
                field("Lvl Two Name") { textfield(obj.objLvlTwo.name)  }
            }

            for (elem in obj.objLvlTwo.objLvlThreeList) {
                fieldset("Data List") {
                    field("Lvl Three Name") { textfield(elem.name) }
                }
            }
        }
        button ("Update") {
            action {
                obj.commit()
            }
        }
    }

}