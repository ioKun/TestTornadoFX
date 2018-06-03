package com.ilobanov.desktop.main

import com.ilobanov.desktop.data.Sender
import com.ilobanov.desktop.detailed.DetailedView
import com.ilobanov.desktop.model.SenderModel
import tornadofx.*

class ObjCardFragment: ListCellFragment<Sender>() {

    private val obj = SenderModel().bindTo(this)

    override val root = hbox {
        spacing = 16.0
        text(obj.name)
        text(obj.objLvlTwo.name)
        obj.objLvlTwo.measurmentsList.onChange {
            for (elem in obj.objLvlTwo.measurmentsList) {
                text { elem.name }
            }
        }
        button("Details") {
            action {
                setInScope(obj, scope)
                workspace.dock(find(DetailedView::class))
            }
        }
    }

}