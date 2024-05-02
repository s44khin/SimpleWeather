package dev.s44khin.simpleweather.common.data.local

import dev.s44khin.simpleweather.common.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.domain.model.TempUnits
import dev.s44khin.simpleweather.common.domain.model.Theme
import javax.inject.Inject

class CommonLocal @Inject constructor(
    private val sharedPrefSettings: SharedPrefSettings,
) {

    var units: TempUnits
        get() = sharedPrefSettings.units
        set(value) {
            sharedPrefSettings.units = value
        }

    val colorFlow get() = sharedPrefSettings.colorFlow

    val themeFlow get() = sharedPrefSettings.themeFlow

    val transparentFlow get() = sharedPrefSettings.transparentFlow

    val alwaysShowLabelFlow get() = sharedPrefSettings.alwaysShowLabelFlow

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