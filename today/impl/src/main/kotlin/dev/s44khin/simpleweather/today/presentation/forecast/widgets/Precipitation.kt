package dev.s44khin.simpleweather.today.presentation.forecast.widgets

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.widgets.WaterAnimation

@Composable
internal fun BoxScope.Precipitation() {
    WaterAnimation()

    Text(
        modifier = Modifier
            .align(Alignment.Center),
        text = "75%",
        style = MaterialTheme.typography.displayMedium,
        color = SimpleTheme.colors.onBackground
    )

    Text(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 16.dp),
        text = "Precipitation",
        style = MaterialTheme.typography.bodyLarge,
        color = SimpleTheme.colors.onBackground
    )
}
