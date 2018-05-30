package com.ilobanov.desktop

import javafx.scene.effect.DropShadow
import javafx.scene.layout.BackgroundPosition
import javafx.scene.layout.BackgroundRepeat
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*
import java.net.URI

class Styles : Stylesheet() {

    companion object {
        val container by cssclass()

        val colorGray = Color.GRAY!!
        val colorPrimary = c("#1976D2")
        val colorPrimaryDark = c("#2196F3")
        val colorPrimaryLight = c("#BBDEFB")
        val colorAccent = c("#009688")
        val colorAccentLight = c("#80CBC4")
        val colorAccentDark = c("#00695C")
        val colorPrimaryText = c("#ffffff")//212121
        val colorSecondaryText = c("#757575")
        val colorDivider = c("#BDBDBD")
        val colorIcons = c("#ffffff")
        val colorError = c("#F44336")

        val sizeTextSmall = 8.pt
        val sizeTextMedium = 14.pt
        val sizeTextLarge = 24.pt
    }

    init {

        container {
            prefWidth = 1366.px
            prefHeight = 768.px
            backgroundColor += colorPrimary

            button {
                padding = box(16.px, 32.px)
                textFill = Color.WHITE
                fontWeight = FontWeight.BOLD
            }
        }

    }

}