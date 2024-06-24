package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.api.domain.model.TempUnits
import dev.s44khin.simpleweather.common.api.domain.model.Theme
import dev.s44khin.simpleweather.common.api.domain.useCases.ResetSettingsUseCase

class ResetSettingsUseCaseImpl(
    private val repository: CommonRepository
) : ResetSettingsUseCase {

    override suspend fun execute() {
        repository.setUnits(units = TempUnits.Kelvin)
        repository.setColor(color = PrimaryColor.CedarChest)
        repository.setTheme(theme = Theme.System)
        repository.setTransparent(transparent = true)
        repository.setAlwaysShowLabel(alwaysShowLabel = false)
    }
}