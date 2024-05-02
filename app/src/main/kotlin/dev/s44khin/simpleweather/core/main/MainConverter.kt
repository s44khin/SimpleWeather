package dev.s44khin.simpleweather.core.main

import dev.s44khin.simpleweather.common.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.common.util.enumValueOrDefault
import javax.inject.Inject

class MainConverter @Inject constructor() {

    fun convert(screenState: MainScreenState) = MainUiState(
        color = enumValueOrDefault(
            string = screenState.color.name,
            default = PrimaryColorVo.CedarChest,
        )
    )
}