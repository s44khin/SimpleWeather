package dev.s44khin.simpleweather.common.data

import dev.s44khin.simpleweather.common.data.local.CommonLocal
import dev.s44khin.simpleweather.common.data.remote.CommonRemote
import dev.s44khin.simpleweather.common.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.domain.model.TempUnits
import dev.s44khin.simpleweather.common.domain.model.Theme

class CommonRepository(
    private val local: CommonLocal,
    private val remote: CommonRemote,
) {

    val unitsFlow get() = local.unitsFlow

    val colorFlow get() = local.colorFlow

    val themeFlow get() = local.themeFlow

    val transparentFlow get() = local.transparentFlow

    val alwaysShowLabelFlow get() = local.alwaysShowLabelFlow

    suspend fun setUnits(units: TempUnits) {
        local.setUnits(units)
    }

    suspend fun setColor(color: PrimaryColor) {
        local.setColor(color)
    }

    suspend fun setTheme(theme: Theme) {
        local.setTheme(theme)
    }

    suspend fun setTransparent(transparent: Boolean) {
        local.setTransparent(transparent)
    }

    suspend fun setAlwaysShowLabel(alwaysShowLabel: Boolean) {
        local.setAlwaysShowLabel(alwaysShowLabel)
    }

    suspend fun searchLocation(name: String) = remote.searchLocation(name)
}