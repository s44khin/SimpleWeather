package dev.s44khin.simpleweather.common.data

import dev.s44khin.simpleweather.common.data.local.CommonLocal
import dev.s44khin.simpleweather.common.domain.model.PrimaryColor
import dev.s44khin.simpleweather.common.domain.model.TempUnits
import javax.inject.Inject

class CommonRepository @Inject constructor(
    private val local: CommonLocal,
) {

    var units: TempUnits
        get() = local.units
        set(value) {
            local.units = value
        }

    val colorFlow get() = local.colorFlow

    suspend fun setColor(color: PrimaryColor) {
        local.setColor(color)
    }
}