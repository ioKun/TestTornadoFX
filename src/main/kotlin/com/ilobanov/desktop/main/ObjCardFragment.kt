package com.ilobanov.desktop.main

import com.ilobanov.desktop.data.ObjLvlOne
import com.ilobanov.desktop.detailed.DetailedView
import com.ilobanov.desktop.model.ObjLvlOneModel
import tornadofx.*
import java.awt.Insets

class ObjCardFragment: ListCellFragment<ObjLvlOne>() {

    private val obj = ObjLvlOneModel().bindTo(this)

    override val root = hbox {
        spacing = 16.0
        text(obj.name)
        text(obj.objLvlTwo.name)
        obj.objLvlTwo.objLvlThreeList.onChange {
            for (elem in obj.objLvlTwo.objLvlThreeList) {
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