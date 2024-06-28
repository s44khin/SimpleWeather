package dev.s44khin.simpleweather.common.api.presentation.model

import androidx.annotation.StringRes
import dev.s44khin.simpleweather.common.api.domain.model.BarometerUnits
import dev.s44khin.simpleweather.resources.CoreStrings
import dev.s44khin.simpleweather.utils.enumValueOrDefault

enum class BarometerUnitsVo {
    Hectopascals, MercuryСolumn;

    val label: Int
        @StringRes
        get() = when (this) {
            Hectopascals -> CoreStrings.pressure_hPa
            MercuryСolumn -> CoreStrings.pressure_mercury_column
        }

    val range: IntRange
        get() = when (this) {
            Hectopascals -> 870..1050
            MercuryСolumn -> 700..800
        }
}

fun BarometerUnits.toBarometerUnitsVo() = enumValueOrDefault(
    string = this.name,
    default = BarometerUnitsVo.MercuryСolumn,
)