package dev.s44khin.simpleweather.common.data

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.api.domain.model.TempUnits
import dev.s44khin.simpleweather.common.api.domain.model.Theme
import dev.s44khin.simpleweather.common.data.local.CommonLocal
import dev.s44khin.simpleweather.common.data.remote.CommonRemote

class CommonRepositoryImpl(
    private val local: CommonLocal,
    private val remote: CommonRemote,
) : CommonRepository {

    override val unitsFlow get() = local.unitsFlow

    override val colorFlow get() = local.colorFlow

    override val themeFlow get() = local.themeFlow

    override val transparentFlow get() = local.transparentFlow

    override val alwaysShowLabelFlow get() = local.alwaysShowLabelFlow

    override suspend fun setUnits(units: TempUnits) {
        local.setUnits(units)
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
}