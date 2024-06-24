package dev.s44khin.simpleweather.common.data.local

import dev.s44khin.simpleweather.common.api.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.api.domain.model.TempUnits
import dev.s44khin.simpleweather.common.api.domain.model.Theme

class CommonLocal(
    private val sharedPrefSettings: SharedPrefSettings,
) {

    val unitsFlow get() = sharedPrefSettings.unitsFlow

    val colorFlow get() = sharedPrefSettings.colorFlow

    val themeFlow get() = sharedPrefSettings.themeFlow

    val transparentFlow get() = sharedPrefSettings.transparentFlow

    val alwaysShowLabelFlow get() = sharedPrefSettings.alwaysShowLabelFlow

    suspend fun setUnits(units: TempUnits) {
        sharedPrefSettings.setUnits(units)
    }

    suspend fun setColor(color: PrimaryColor) {
        sharedPrefSettings.setColor(color)
    }

    suspend fun setTheme(theme: Theme) {
        sharedPrefSettings.setTheme(theme)
    }

    suspend fun setTransparent(transparent: Boolean) {
        sharedPrefSettings.setTransparent(transparent)
    }

    suspend fun setAlwaysShowLabel(alwaysShowLabel: Boolean) {
        sharedPrefSettings.setAlwaysShowLabel(alwaysShowLabel)
    }
}