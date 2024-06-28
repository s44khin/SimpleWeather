package dev.s44khin.simpleweather.today.presentation.forecast.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import dev.s44khin.simpleweather.resources.CoreRaw
import dev.s44khin.simpleweather.resources.CoreStrings
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastSuntimeVo
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.widgets.LottieIcon

@Composable
internal fun BoxScope.CurrentSun(suntime: ForecastSuntimeVo) {
    LottieIcon(
        modifier = Modifier
            .align(Alignment.TopCenter)
            .fillMaxSize(0.7f),
        rawRes = CoreRaw.ic_clear_day
    )

    Row(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column {
            Text(
                text = suntime.sunrise,
                style = MaterialTheme.typography.titleMedium,
                color = SimpleTheme.colors.onBackground
            )

            Text(
                text = stringResource(CoreStrings.sunrise),
                style = MaterialTheme.typography.bodyMedium,
                color = SimpleTheme.colors.onBackgroundUnselected
            )
        }

        Column {
            Text(
                text = suntime.sunset,
                style = MaterialTheme.typography.titleMedium,
                color = SimpleTheme.colors.onBackground
            )

            Text(
                text = stringResource(CoreStrings.sunset),
                style = MaterialTheme.typography.bodyMedium,
                color = SimpleTheme.colors.onBackgroundUnselected
            )
        }
    }
}
