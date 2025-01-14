package dev.s44khin.simpleweather.main

import dev.s44khin.simpleweather.common.api.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.common.api.presentation.model.ThemeVo
import dev.s44khin.simpleweather.utils.enumValueOrDefault

internal object MainConverter {

    fun convert(screenState: MainScreenState) = MainUiState(
        color = enumValueOrDefault(
            string = screenState.color.name,
            default = PrimaryColorVo.CedarChest,
        ),
        theme = enumValueOrDefault(
            string = screenState.theme.name,
            default = ThemeVo.System,
        ),
        transparent = screenState.transparent,
        alwaysShowLabel = screenState.alwaysShowLabel,
    )
}