package dev.s44khin.simpleweather.settings.presentation.model

import dev.s44khin.simpleweather.resources.CoreStrings
import dev.s44khin.simpleweather.utils.NativeText

internal enum class TempUnitsVo(
    val label: NativeText,
    val sample: NativeText,
) {
    Fahrenheit(
        label = NativeText.Resource(CoreStrings.units_fahrenheit),
        sample = NativeText.Resource(CoreStrings.units_fahrenheit_sample)
    ),

    Celsius(
        label = NativeText.Resource(CoreStrings.units_celsius),
        sample = NativeText.Resource(CoreStrings.units_celsius_sample)
    ),

    Kelvin(
        label = NativeText.Resource(CoreStrings.units_kelvin),
        sample = NativeText.Resource(CoreStrings.units_kelvin_sample)
    ),
}
