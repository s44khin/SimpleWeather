package dev.s44khin.simpleweather.main

import dev.s44khin.simpleweather.common.api.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.api.domain.model.Theme

internal data class MainScreenState(
    val color: PrimaryColor,
    val theme: Theme,
    val transparent: Boolean,
    val alwaysShowLabel: Boolean,
)