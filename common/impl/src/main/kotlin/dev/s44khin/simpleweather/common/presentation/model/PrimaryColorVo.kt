package dev.s44khin.simpleweather.common.presentation.model

import androidx.compose.ui.graphics.Color

enum class PrimaryColorVo(
    val light: Color,
    val dark: Color,
) {

    CedarChest(
        light = Color(0xff86352e),
        dark = Color(0xfff6d5d2),
    ),

    TrueBlue(
        light = Color(0xff0056d6),
        dark = Color(0xff7ddaff),
    ),

    LightPeriwinkle(
        light = Color(0xff58547f),
        dark = Color(0xffc9cde5)
    ),

    IguanaGreen(
        light = Color(0xff234229),
        dark = Color(0xffc0dac0)
    ),

    DavyGrey(
        light = Color(0xff4a4245),
        dark = Color(0xffc0b9bd)
    ),

    LightCobaltBlue(
        light = Color(0xff3e4395),
        dark = Color(0xffb0c3f1)
    ),

    PalmLeaf(
        light = Color(0xff435b30),
        dark = Color(0xffacc78f)
    ),

    Gold(
        light = Color(0xff90542d),
        dark = Color(0xffdfcc8f)
    )
}