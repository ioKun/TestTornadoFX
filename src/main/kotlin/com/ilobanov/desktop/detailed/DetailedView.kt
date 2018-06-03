package com.ilobanov.desktop.detailed

import com.ilobanov.desktop.model.SenderModel
import tornadofx.*

class DetailedView: View(null, null) {

    private val obj: SenderModel by inject()

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