package dev.s44khin.simpleweather.uikit.util

import androidx.compose.ui.Modifier

fun Modifier.ifThen(condition: Boolean, then: Modifier.() -> Modifier) = if (condition) {
    this.then()
} else {
    this
}