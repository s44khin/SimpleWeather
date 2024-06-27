package dev.s44khin.simpleweather.today.presentation.forecast.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import dev.s44khin.simpleweather.resources.CoreRaw
import dev.s44khin.simpleweather.resources.CoreStrings
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme

@Immutable
internal data class ForecastCurrentVo(
    val temp: String,
    val feelsLike: String,
    val min: String?,
    val max: String?,
    val humidity: String,
    val pressure: ForecastCurrentPressureVo,
    val uvi: ForecastCurrentUviVo,
    val iconId: String,
    val weather: ForecastCurrentWeatherVo,
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

enum class ForecastCurrentUviTypeVo {
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
            High -> SimpleTheme.staticColors.uviOrange
            VeryHigh -> SimpleTheme.staticColors.uviRed
            Extreme -> SimpleTheme.staticColors.uviViolet
            else -> null
        }
}
