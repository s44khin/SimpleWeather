package dev.s44khin.simpleweather.today.presentation.forecast.widgets

import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.today.presentation.forecast.TodayForecastUiState

private enum class TodayForecastKeys {
    CurrentForecast, Humidity, Pressure, UVIndex, Hourly, Wind
}

@Composable
internal fun TodayForecastContent(
    uiState: TodayForecastUiState,
    modifier: Modifier = Modifier,
    lazyGridState: LazyGridState = rememberLazyGridState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    reverseLayout: Boolean = false,
    flingBehavior: FlingBehavior = ScrollableDefaults.flingBehavior(),
    userScrollEnabled: Boolean = true,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        state = lazyGridState,
        contentPadding = contentPadding,
        reverseLayout = reverseLayout,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        flingBehavior = flingBehavior,
        userScrollEnabled = userScrollEnabled
    ) {
        if (uiState.current != null) {
            squareBox(key = TodayForecastKeys.CurrentForecast) {
                CurrentForecast(
                    current = uiState.current,
                    units = uiState.units,
                )
            }

            squareBox(key = TodayForecastKeys.Humidity) {
                Humidity(
                    current = uiState.current
                )
            }

            rectangleColumn(
                key = TodayForecastKeys.Hourly,
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                HourlyForecast()
            }

            squareBox(
                key = TodayForecastKeys.Pressure,
                contentPadding = PaddingValues(16.dp)
            ) {
                Pressure(
                    current = uiState.current
                )
            }

            squareColumn(
                key = TodayForecastKeys.UVIndex,
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                borderColor = { uiState.current.uvi.type.border },
            ) {
                UvIndex(
                    uvindex = uiState.current.uvi
                )
            }

            rectangleColumn(
                modifier = Modifier.fillMaxWidth(),
                key = TodayForecastKeys.Wind,
                contentPadding = PaddingValues(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CurrentWind(
                    wind = uiState.current.wind
                )
            }
        }
    }
}