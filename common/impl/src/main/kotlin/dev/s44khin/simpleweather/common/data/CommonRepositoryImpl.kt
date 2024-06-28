package dev.s44khin.simpleweather.common.data

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.model.BarometerUnits
import dev.s44khin.simpleweather.common.api.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.api.domain.model.Theme
import dev.s44khin.simpleweather.common.api.domain.model.Units
import dev.s44khin.simpleweather.common.data.local.CommonLocal
import dev.s44khin.simpleweather.common.data.remote.CommonRemote

internal class CommonRepositoryImpl(
    private val local: CommonLocal,
    private val remote: CommonRemote,
) : CommonRepository {

    override val unitsFlow get() = local.unitsFlow

    override val barometerUnitsFlow get() = local.barometerUnitsFlow

    override val colorFlow get() = local.colorFlow

    override val themeFlow get() = local.themeFlow

    override val transparentFlow get() = local.transparentFlow

    override val alwaysShowLabelFlow get() = local.alwaysShowLabelFlow

    override suspend fun setUnits(units: Units) {
        local.setUnits(units)
    }

    override suspend fun setBarometerUnits(units: BarometerUnits) {
        local.setBarometerUnits(units)
    }

    override suspend fun setColor(color: PrimaryColor) {
        local.setColor(color)
    }

    override suspend fun setTheme(theme: Theme) {
        local.setTheme(theme)
    }

    override suspend fun setTransparent(transparent: Boolean) {
        local.setTransparent(transparent)
    }

    override suspend fun setAlwaysShowLabel(alwaysShowLabel: Boolean) {
        local.setAlwaysShowLabel(alwaysShowLabel)
    }

    override suspend fun searchLocation(name: String) = remote.searchLocation(name)

    override suspend fun getAllWeather(tempUnits: Units, barometerUnits: BarometerUnits) = remote.getForecast(
        tempUnits = tempUnits,
        barometerUnits = barometerUnits
    )
}