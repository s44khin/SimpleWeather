package dev.s44khin.simpleweather.common.data.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.s44khin.simpleweather.common.domain.model.TempUnits
import dev.s44khin.simpleweather.common.util.getEnum
import dev.s44khin.simpleweather.common.util.putEnum
import javax.inject.Inject

class SharedPrefSettings @Inject constructor(
    @ApplicationContext
    private val context: Context,
) {

    private companion object {
        const val SETTINGS = "settings"
        const val UNITS = "units"
    }

    private val sharedPreferences = context.getSharedPreferences(SETTINGS, Context.MODE_PRIVATE)

    var units: TempUnits
        get() = sharedPreferences.getEnum(key = UNITS, default = TempUnits.Kelvin)
        set(value) = sharedPreferences.putEnum(key = UNITS, value = value)
}