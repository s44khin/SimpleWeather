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
)

internal val LocalSimpleColors = staticCompositionLocalOf { getLightColors() }

internal fun getLightColors() = SimpleColors(
    primary = Color(0xff0277ff),
    root = Color(0xffeceef0),
    background = Color(0xffffffff),
    onBackground = Color(0xff000000),
    onBackgroundUnselected = Color(0x80000000),
    onPrimary = Color(0xffffffff),
    backgroundTransparent = Color(0xCDFFFFFF),
)

internal fun getDarkColors() = SimpleColors(
    primary = Color(0xff0277ff),
    root = Color(0xff141414),
    background = Color(0xff282424),
    onBackground = Color(0xffffffff),
    onBackgroundUnselected = Color(0x80FFFFFF),
    onPrimary = Color(0xffffffff),
    backgroundTransparent = Color(0xDE282424),
)
