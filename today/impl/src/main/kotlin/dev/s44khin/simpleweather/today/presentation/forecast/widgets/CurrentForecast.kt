package dev.s44khin.simpleweather.today.presentation.forecast.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.resources.rawfromIconId
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastCurrentVo
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.widgets.LottieIcon

@Composable
internal fun BoxScope.CurrentForecast(
    current: ForecastCurrentVo,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = current.temp,
            style = MaterialTheme.typography.displayMedium,
            color = SimpleTheme.colors.onBackground
        )

        LottieIcon(
            modifier = Modifier.size(80.dp),
            rawRes = rawfromIconId(iconId = current.iconId)
        )
    }
}
