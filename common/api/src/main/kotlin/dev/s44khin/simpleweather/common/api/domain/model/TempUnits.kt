package dev.s44khin.simpleweather.common.api.domain.model

enum class TempUnits {
    Fahrenheit, Celsius, Kelvin;

    val isDefault get() = this == Kelvin

    val isNotDefault get() = isDefault.not()

    companion object {
        val Default get() = Kelvin
    }
}
