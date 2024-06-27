package dev.s44khin.simpleweather.today.presentation.forecast.widgets

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.resources.CoreRaw
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.util.Spacer
import dev.s44khin.simpleweather.uikit.widgets.LottieIcon
import kotlin.random.Random

@Composable
internal fun ColumnScope.HourlyForecast() {
    Text(
        modifier = Modifier.padding(horizontal = 16.dp),
        text = "Rain is expected around 17:00",
        style = MaterialTheme.typography.bodyMedium,
        color = SimpleTheme.colors.onBackgroundUnselected,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )

    Spacer(height = 8.dp)

    HorizontalDivider(
        modifier = Modifier.padding(horizontal = 16.dp),
        thickness = 0.5.dp,
        color = SimpleTheme.colors.divider,
    )

    Spacer(height = 8.dp)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(width = 2.dp)

        repeat(24) {
            HourlyForecastItem(it)
        }

        Spacer(width = 2.dp)
    }

    Spacer(height = 8.dp)
}

@Composable
private fun HourlyForecastItem(index: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = index.toString(),
            style = MaterialTheme.typography.titleMedium,
            color = SimpleTheme.colors.onBackgroundUnselected
        )

        LottieIcon(
            modifier = Modifier.size(45.dp),
            rawRes = CoreRaw.ic_09n
        )

        Text(
            text = "${Random.nextInt(10, 23)}°",
            style = MaterialTheme.typography.titleMedium,
            color = SimpleTheme.colors.onBackground
        )
    }
}