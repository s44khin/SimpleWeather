package dev.s44khin.simpleweather.today.presentation.forecast.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
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
import dev.s44khin.simpleweather.uikit.widgets.LottieIcon

@Composable
internal fun BoxScope.Pressure(
    current: ForecastCurrentVo
) {
    Row(
        modifier = Modifier.align(Alignment.TopCenter),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            modifier = Modifier.alignByBaseline(),
            text = current.pressure.value.toString(),
            style = MaterialTheme.typography.headlineMedium,
            color = SimpleTheme.colors.onBackground,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            modifier = Modifier.alignByBaseline(),
            text = stringResource(CoreStrings.pressure_hPa),
            style = MaterialTheme.typography.bodyLarge,
            color = SimpleTheme.colors.onBackgroundUnselected,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }

    LottieIcon(
        modifier = Modifier.align(Alignment.Center),
        rawRes = current.pressure.raw
    )

    Text(
        modifier = Modifier.align(Alignment.BottomCenter),
        text = stringResource(CoreStrings.pressure),
        style = MaterialTheme.typography.bodyLarge,
        color = SimpleTheme.colors.onBackground,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}