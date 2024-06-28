package dev.s44khin.simpleweather.uikit.util

import androidx.compose.ui.Modifier

inline fun Modifier.ifThen(condition: Boolean, then: Modifier.() -> Modifier) = if (condition) {
    this.then()
} else {
    this
}

inline fun <T> Modifier.ifNotNull(
    value: T?,
    additionalCondition: () -> Boolean = { true },
    then: Modifier.(value: T) -> Modifier,
) = if (value != null && additionalCondition()) {
    then(value)
} else {
    this
}