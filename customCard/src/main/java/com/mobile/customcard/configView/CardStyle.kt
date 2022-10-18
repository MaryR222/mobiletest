package com.mobile.customcard.configView

class CardStyle() {
    var fonts: FontConfig? = null
    var colors: ColorConfig? = null

    constructor(fontConfig: FontConfig?, colorCofig: ColorConfig?) : this() {
        this.fonts = fontConfig
        this.colors = colorCofig
    }
}