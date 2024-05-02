package dev.s44khin.simpleweather.common.domain.model

import androidx.compose.ui.graphics.Color

enum class PrimaryColor(
    val primary: Color,
    val onPrimary: Color,
) {

    Blue(
        primary = Color(0xff0277ff),
        onPrimary = Color(0xffffffff)
    ),

    Periwinkle(
        primary = Color(0xffA7ABDD),
        onPrimary = Color(0xff000000)
    ),

    Sage(
        primary = Color(0xffB4C292),
        onPrimary = Color(0xff000000)
    ),

    Wenge(
        primary = Color(0xff5D576B),
        onPrimary = Color(0xffffffff)
    ),

    CoralPink(
        primary = Color(0xffFE938C),
        onPrimary = Color(0xff000000)
    ),

    TeaGreen(
        primary = Color(0xffC9D5B5),
        onPrimary = Color(0xff000000)
    ),

    Licorice(
        primary = Color(0xff230C0F),
        onPrimary = Color(0xffffffff)
    ),

    MintCream(
        primary = Color(0xffEBF5EE),
        onPrimary = Color(0xff000000)
    ),

    RaisinBlack(
        primary = Color(0xff221D23),
        onPrimary = Color(0xffffffff)
    ),

    SpaceCadet(
        primary = Color(0xff2A324B),
        onPrimary = Color(0xffffffff)
    ),
}