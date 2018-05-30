package com.ilobanov.desktop

import com.ilobanov.desktop.main.MainView
import tornadofx.App
import tornadofx.UIComponent
import tornadofx.Workspace

class App : App(Workspace::class, Styles::class) {

    override fun onBeforeShow(view: UIComponent) {
        workspace.dock<MainView>()
    }

}