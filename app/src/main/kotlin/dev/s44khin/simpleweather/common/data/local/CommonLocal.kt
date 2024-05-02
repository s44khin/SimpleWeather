package dev.s44khin.simpleweather.common.data.local

import dev.s44khin.simpleweather.common.domain.model.TempUnits
import javax.inject.Inject

class CommonLocal @Inject constructor(
    private val sharedPrefSettings: SharedPrefSettings,
) {

    var units: TempUnits
        get() = sharedPrefSettings.units
        set(value) {
            sharedPrefSettings.units = value
        }
}