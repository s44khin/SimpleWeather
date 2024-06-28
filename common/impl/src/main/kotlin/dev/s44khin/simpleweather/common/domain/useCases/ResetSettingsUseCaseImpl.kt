package dev.s44khin.simpleweather.common.domain.useCases

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.model.BarometerUnits
import dev.s44khin.simpleweather.common.api.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.api.domain.model.Theme
import dev.s44khin.simpleweather.common.api.domain.model.Units
import dev.s44khin.simpleweather.common.api.domain.useCases.ResetSettingsUseCase

internal class ResetSettingsUseCaseImpl(
    private val repository: CommonRepository
) : ResetSettingsUseCase {

    override suspend fun execute() {
        repository.setUnits(units = Units.Default)
        repository.setBarometerUnits(units = BarometerUnits.MercuryСolumn)
        repository.setColor(color = PrimaryColor.CedarChest)
        repository.setTheme(theme = Theme.System)
        repository.setTransparent(transparent = true)
        repository.setAlwaysShowLabel(alwaysShowLabel = false)
    }
}