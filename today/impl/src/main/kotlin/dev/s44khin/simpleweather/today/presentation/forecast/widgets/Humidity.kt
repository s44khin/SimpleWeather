package dev.s44khin.simpleweather.today.presentation.forecast.widgets

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.resources.CoreStrings
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastCurrentVo
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.widgets.WaterAnimation

@Composable
internal fun BoxScope.Humidity(
    current: ForecastCurrentVo
) {
    WaterAnimation(
        modifier = Modifier.fillMaxSize(),
        waveHeightRatio = current.humidity.toFloat()
    )

    Text(
        modifier = Modifier.align(Alignment.Center),
        text = "${current.humidity}%",
        style = MaterialTheme.typography.displayMedium,
        color = SimpleTheme.colors.onBackground
    )

    Text(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(16.dp),
        text = stringResource(CoreStrings.humidity),
        style = MaterialTheme.typography.bodyLarge,
        color = SimpleTheme.colors.onBackground,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}