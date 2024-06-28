package dev.s44khin.simpleweather.today.presentation.forecast.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import dev.s44khin.simpleweather.resources.CoreRaw
import dev.s44khin.simpleweather.resources.CoreStrings
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import kotlin.math.roundToInt

@Immutable
internal data class ForecastCurrentVo(
    val locationName: String,
    val temp: String,
    val feelsLike: String,
    val min: String?,
    val max: String?,
    val humidity: String,
    val pressure: ForecastCurrentPressureVo,
    val uvi: ForecastCurrentUviVo,
    val iconId: String,
    val weather: ForecastCurrentWeatherVo,
    val wind: ForecustCurrentWindVo,
    val precipitation: ForecastPrecipitationVo,
    val time: String,
    val sintime: ForecastSuntimeVo,
)

@Immutable
internal data class ForecastCurrentWeatherVo(
    val main: String,
    val description: String,
)

@Immutable
internal data class ForecastCurrentPressureVo(
    val value: Int,
    val isLow: Boolean,
) {

    val raw: Int = if (isLow) CoreRaw.ic_pressure_low else CoreRaw.ic_pressure_high
}

@Immutable
internal data class ForecastCurrentUviVo(
    val value: Float,
    val type: ForecastCurrentUviTypeVo,
)

internal enum class ForecastCurrentUviTypeVo {
    Low, Moderate, High, VeryHigh, Extreme;

    val message: String
        @Composable
        get() = when (this) {
            Low -> stringResource(CoreStrings.uvindex_low)
            Moderate -> stringResource(CoreStrings.uvindex_moderate)
            High -> stringResource(CoreStrings.uvindex_high)
            VeryHigh -> stringResource(CoreStrings.uvindex_very_high)
            Extreme -> stringResource(CoreStrings.uvindex_extreme)
        }

    val border: Color?
        @Composable
        get() = when (this) {
            VeryHigh -> SimpleTheme.staticColors.uviRed
            Extreme -> SimpleTheme.staticColors.uviViolet
            else -> null
        }
}

@Immutable
internal data class ForecustCurrentWindVo(
    val speed: Int,
    val degree: Float,
    val gust: Int,
) {

    val label: String
        @Composable
        get() = stringResource(
            id = when (degree) {
                in 337.5f..360f, in 0f..<22.5f -> CoreStrings.wind_north
                in 22.5f..<67.5f -> CoreStrings.wind_north_east
                in 67.5f..<112.5f -> CoreStrings.wind_east
                in 112.5f..<157.5f -> CoreStrings.wind_east_south
                in 157.5f..<202.5f -> CoreStrings.wind_south
                in 202.5f..<247.5f -> CoreStrings.wind_south_west
                in 247.5f..<292.5f -> CoreStrings.wind_west
                else -> CoreStrings.wind_west_north
            }
        )
}

@Immutable
internal data class ForecastPrecipitationVo(
    val pop: Int,
    val rain: Float?,
    val snow: Float?,
) {
    val label: String?
        @Composable
        get() = when {
            rain.isValid() && snow.isValid() -> stringResource(CoreStrings.precipitation_rain_snow)
            rain.isValid() -> stringResource(CoreStrings.precipitation_rain)
            snow.isValid() -> stringResource(CoreStrings.precipitation_snow)
            else -> null
        }

    val value = (rain?.roundToInt() ?: snow?.roundToInt())?.toString() ?: ""

    val showRain = rain.isValid()

    private fun Float?.isValid() = this != null && this != 0.0f
}

@Immutable
internal data class ForecastSuntimeVo(
    val sunrise: String,
    val sunset: String,
    val isNight: Boolean,
)
