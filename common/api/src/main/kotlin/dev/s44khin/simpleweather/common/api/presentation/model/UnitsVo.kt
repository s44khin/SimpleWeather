package dev.s44khin.simpleweather.common.api.presentation.model

import dev.s44khin.simpleweather.common.api.domain.model.Units
import dev.s44khin.simpleweather.resources.CoreStrings
import dev.s44khin.simpleweather.utils.NativeText
import dev.s44khin.simpleweather.utils.enumValueOrDefault

enum class UnitsVo(
    val tempLabel: NativeText,
    val tempSample: NativeText,
    val tempPin: NativeText,
    val speedPin: NativeText,
) {

    Default(
        tempLabel = NativeText.Resource(CoreStrings.units_kelvin),
        tempSample = NativeText.Resource(CoreStrings.units_kelvin_sample),
        tempPin = NativeText.Resource(CoreStrings.units_kelvin_pin),
        speedPin = NativeText.Resource(CoreStrings.units_default_speed),
    ),

    Metric(
        tempLabel = NativeText.Resource(CoreStrings.units_celsius),
        tempSample = NativeText.Resource(CoreStrings.units_celsius_sample),
        tempPin = NativeText.Resource(CoreStrings.units_celsius_pin),
        speedPin = NativeText.Resource(CoreStrings.units_metric_speed),
    ),

    Imperial(
        tempLabel = NativeText.Resource(CoreStrings.units_fahrenheit),
        tempSample = NativeText.Resource(CoreStrings.units_fahrenheit_sample),
        tempPin = NativeText.Resource(CoreStrings.units_fahrenheit_pin),
        speedPin = NativeText.Resource(CoreStrings.units_imperial_speed),
    );

    val isDefault get() = this == Default

    val isNotDefault get() = isDefault.not()

    companion object;
}

fun Units.toUnitsVo() = enumValueOrDefault(
    string = this.name,
    default = UnitsVo.Default,
)
