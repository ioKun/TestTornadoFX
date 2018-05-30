package com.ilobanov.desktop.model

import com.ilobanov.desktop.data.ObjLvlThree
import tornadofx.ItemViewModel

class ObjLvlThreeModel : ItemViewModel<ObjLvlThree>() {

    val id = bind(ObjLvlThree::id)
    val name = bind(ObjLvlThree::name)

    override fun onCommit() {
        item = ObjLvlThree(
            id.value,
            name.value
        )
    }
}