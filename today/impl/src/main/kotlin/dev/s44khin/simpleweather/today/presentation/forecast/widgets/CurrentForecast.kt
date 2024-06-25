package dev.s44khin.simpleweather.today.presentation.forecast.widgets

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastCurrentVo

@Composable
internal fun ColumnScope.CurrentForecast(
    current: ForecastCurrentVo,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = current.temp,
            style = MaterialTheme.typography.displaySmall,
        )
    }
}
