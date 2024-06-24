package dev.s44khin.simpleweather.settings.presentation.model

import dev.s44khin.simpleweather.R
import dev.s44khin.simpleweather.utils.NativeText

enum class TempUnitsVo(
    val label: NativeText,
    val sample: NativeText,
) {
    Fahrenheit(
        label = NativeText.Resource(R.string.units_fahrenheit),
        sample = NativeText.Resource(R.string.units_fahrenheit_sample)
    ),

    Celsius(
        label = NativeText.Resource(R.string.units_celsius),
        sample = NativeText.Resource(R.string.units_celsius_sample)
    ),

    Kelvin(
        label = NativeText.Resource(R.string.units_kelvin),
        sample = NativeText.Resource(R.string.units_kelvin_sample)
    ),
}
