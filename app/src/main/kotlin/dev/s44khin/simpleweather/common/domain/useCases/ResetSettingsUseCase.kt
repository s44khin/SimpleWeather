package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.data.CommonRepository
import dev.s44khin.simpleweather.common.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.domain.model.TempUnits
import dev.s44khin.simpleweather.common.domain.model.Theme
import dev.s44khin.simpleweather.common.presentation.model.PrimaryColorVo

class ResetSettingsUseCase(
    private val repository: CommonRepository
) {

    suspend fun execute() {
        repository.setUnits(units = TempUnits.Kelvin)
        repository.setColor(
            color = PrimaryColor(
                name = PrimaryColorVo.CedarChest.name
            )
        )
        repository.setTheme(theme = Theme.System)
        repository.setTransparent(transparent = true)
        repository.setAlwaysShowLabel(alwaysShowLabel = false)
    }
}