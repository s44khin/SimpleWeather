package dev.s44khin.simpleweather.common.api.domain

import dev.s44khin.simpleweather.common.api.domain.model.BarometerUnits
import dev.s44khin.simpleweather.common.api.domain.model.Forecast
import dev.s44khin.simpleweather.common.api.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.api.domain.model.SearchLocation
import dev.s44khin.simpleweather.common.api.domain.model.Theme
import dev.s44khin.simpleweather.common.api.domain.model.Units
import kotlinx.coroutines.flow.StateFlow

interface CommonRepository {

    val unitsFlow: StateFlow<Units>

    val barometerUnitsFlow: StateFlow<BarometerUnits>

    val colorFlow: StateFlow<PrimaryColor>

    val themeFlow: StateFlow<Theme>

    val transparentFlow: StateFlow<Boolean>

    val alwaysShowLabelFlow: StateFlow<Boolean>

    suspend fun setUnits(units: Units)

    suspend fun setBarometerUnits(units: BarometerUnits)

    suspend fun setColor(color: PrimaryColor)

    suspend fun setTheme(theme: Theme)

    suspend fun setTransparent(transparent: Boolean)

    suspend fun setAlwaysShowLabel(alwaysShowLabel: Boolean)

    suspend fun searchLocation(name: String): List<SearchLocation>

    suspend fun getAllWeather(tempUnits: Units, barometerUnits: BarometerUnits): Forecast
}