package dev.s44khin.simpleweather.uikit.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class SimpleColors(
    val primary: Color,
    val root: Color,
    val background: Color,
    val backgroundTransparent: Color,
    val onBackground: Color,
    val onBackgroundUnselected: Color,
    val onPrimary: Color,
    val divider: Color,
    val firtsWave: Color,
    val secondWave: Color,
    val pointColor: Color,
    val pointBorderColor: Color,
)

@Immutable
data class StaticColors(
    val uviOrange: Color = Color(0xffff8d02),
    val uviRed: Color = Color(0xffff3c00),
    val uviViolet: Color = Color(0xff9936d4),
)

internal val LocalSimpleColors = staticCompositionLocalOf {
    getLightColors()
}

internal val LocalStaticeColors = staticCompositionLocalOf {
    StaticColors()
}

internal fun getLightColors(
    primary: Color = Color(0xff0277ff),
    onPrimary: Color = Color(0xffffffff),
    transparent: Boolean = true,
) = SimpleColors(
    primary = primary,
    root = Color(0xffeceef0),
    background = Color(0xffffffff),
    onBackground = Color(0xff000000),
    onBackgroundUnselected = Color(0x80000000),
    onPrimary = onPrimary,
    backgroundTransparent = Color(if (transparent) 0xCDFFFFFF else 0xffffffff),
    divider = Color(0xFFDFDFDF),
    firtsWave = Color(0xFF5995FF),
    secondWave = Color(0xFF3E77FF),
    pointColor = Color.White,
    pointBorderColor = Color.Black,
)

internal fun getDarkColors(
    primary: Color = Color(0xff0277ff),
    onPrimary: Color = Color(0xffffffff),
    transparent: Boolean = true,
) = SimpleColors(
    primary = primary,
    root = Color(0xff141414),
    background = Color(0xff282424),
    onBackground = Color(0xffffffff),
    onBackgroundUnselected = Color(0x80FFFFFF),
    onPrimary = onPrimary,
    backgroundTransparent = Color(if (transparent) 0xDE282424 else 0xff282424),
    divider = Color(0xFF131313),
    firtsWave = Color(0xff0a3ecd),
    secondWave = Color(0xff0961ff),
    pointColor = Color.Black,
    pointBorderColor = Color.White,
)
