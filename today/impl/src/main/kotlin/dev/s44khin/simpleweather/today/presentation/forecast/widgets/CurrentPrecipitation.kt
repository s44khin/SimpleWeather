package dev.s44khin.simpleweather.today.presentation.forecast.widgets

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.resources.CoreRaw
import dev.s44khin.simpleweather.resources.CoreStrings
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastPrecipitationVo
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.widgets.LottieIcon
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin
import kotlin.random.Random

@Composable
internal fun BoxScope.CurrentPrecipitation(
    precipitation: ForecastPrecipitationVo
) {
    if (precipitation.showRain) {
        LottieIcon(
            rawRes = CoreRaw.ic_rain,
        )
    }

    Text(
        modifier = Modifier.padding(16.dp),
        text = "${precipitation.pop}%",
        style = MaterialTheme.typography.displayMedium,
        color = SimpleTheme.colors.onBackground,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
            .align(Alignment.BottomStart),
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        Text(
            text = stringResource(CoreStrings.precipitation),
            style = MaterialTheme.typography.bodyMedium,
            color = SimpleTheme.colors.onBackgroundUnselected,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
        )

        if (precipitation.rain != null || precipitation.snow != null) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    modifier = Modifier.alignByBaseline(),
                    text = precipitation.value,
                    style = MaterialTheme.typography.bodyMedium,
                    color = SimpleTheme.colors.onBackgroundUnselected,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    modifier = Modifier.alignByBaseline(),
                    text = stringResource(CoreStrings.precipitation_mm),
                    style = MaterialTheme.typography.bodyMedium,
                    color = SimpleTheme.colors.onBackgroundUnselected,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Text(
                text = precipitation.label ?: "",
                style = MaterialTheme.typography.bodyMedium,
                color = SimpleTheme.colors.onBackgroundUnselected,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun FrostPattern() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val patternColor = Color(0xFFD6E9F1)
        val backgroundColor = Color(0xFF6DA1B1)

        drawRect(color = backgroundColor, size = size)

        val radius = min(size.width, size.height) / 3
        val numLines = 50
        val lineLength = 100f

        repeat(numLines) {
            val angle = Random.nextInt(0, 360).toFloat()
            val startX = size.width / 2 + radius * cos(Math.toRadians(angle.toDouble())).toFloat()
            val startY = size.height / 2 + radius * sin(Math.toRadians(angle.toDouble())).toFloat()
            val endX = startX + lineLength * cos(Math.toRadians(angle.toDouble())).toFloat()
            val endY = startY + lineLength * sin(Math.toRadians(angle.toDouble())).toFloat()
            drawLine(color = patternColor, start = Offset(startX, startY), end = Offset(endX, endY))
        }
    }
}