package dev.s44khin.simpleweather.common.api.presentation.model

import dev.s44khin.simpleweather.common.api.domain.model.BarometerUnits
import dev.s44khin.simpleweather.resources.CoreStrings
import dev.s44khin.simpleweather.utils.NativeText
import dev.s44khin.simpleweather.utils.enumValueOrDefault

enum class BarometerUnitsVo(
    val label: NativeText,
    val range: IntRange,
    val sample: NativeText,
) {
    Hectopascals(
        label = NativeText.Resource(CoreStrings.pressure_hPa),
        range = 870..1050,
        sample = NativeText.Resource(CoreStrings.pressure_hpa_sample)
    ),

    MercuryСolumn(
        label = NativeText.Resource(CoreStrings.pressure_mercury_column),
        range = 700..800,
        sample = NativeText.Resource(CoreStrings.pressure_mercury_column_sample)
    );
}

fun BarometerUnits.toBarometerUnitsVo() = enumValueOrDefault(
    string = this.name,
    default = BarometerUnitsVo.MercuryСolumn,
)