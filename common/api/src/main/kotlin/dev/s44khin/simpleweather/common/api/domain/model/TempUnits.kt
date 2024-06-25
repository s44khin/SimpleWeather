package dev.s44khin.simpleweather.common.api.domain.model

enum class TempUnits(
    val symbol: String,
    val unitName: String,
) {
    Fahrenheit(
        symbol = "°",
        unitName = "imperial"
    ),

    Celsius(
        symbol = "°",
        unitName = "metric"
    ),

    Kelvin(
        symbol = "K",
        unitName = "standard"
    );

    val isDefault get() = this == Kelvin

    val isNotDefault get() = isDefault.not()

    companion object {
        val Default get() = Kelvin
    }
}
