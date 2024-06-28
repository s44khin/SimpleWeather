package dev.s44khin.simpleweather.today.presentation.forecast.widgets

import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.common.api.presentation.model.BarometerUnitsVo
import dev.s44khin.simpleweather.resources.CoreStrings
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastCurrentPressureVo
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.util.Spacer
import kotlin.math.cos
import kotlin.math.sin

@Composable
internal fun BoxScope.Pressure(
    pressure: ForecastCurrentPressureVo,
    units: BarometerUnitsVo
) {
    Barometer(
        modifier = Modifier
            .align(Alignment.Center)
            .fillMaxSize(),
        value = pressure.value,
        rangeValues = units.range
    )

    Column(
        modifier = Modifier.align(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = pressure.value.toString(),
            style = MaterialTheme.typography.displayMedium,
            color = SimpleTheme.colors.onBackground,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        Text(
            text = stringResource(units.label),
            style = MaterialTheme.typography.bodyMedium,
            color = SimpleTheme.colors.onBackgroundUnselected,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(height = 4.dp)

        Text(
            text = stringResource(CoreStrings.pressure),
            style = MaterialTheme.typography.bodyMedium,
            color = SimpleTheme.colors.onBackgroundUnselected,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
private fun Barometer(
    modifier: Modifier = Modifier,
    value: Int,
    rangeValues: IntRange,
) {
    val onBackground = SimpleTheme.colors.onBackground
    val onBackgroundUnselected = SimpleTheme.colors.onBackgroundUnselected
    val arrowColor = SimpleTheme.colors.primary

    val finalValue =
        ((value - rangeValues.first) / (rangeValues.last - rangeValues.first).toFloat() * 300).coerceIn(0f..300f)

    val infiniteTransition = rememberInfiniteTransition()
    val animatedValue by infiniteTransition.animateFloat(
        initialValue = finalValue - 2f.coerceIn(0f..300f),
        targetValue = (finalValue + 2f).coerceIn(0f..300f),
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(),
            repeatMode = RepeatMode.Reverse,
        )
    )

    Canvas(modifier = modifier.aspectRatio(1f)) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        val radius = (canvasWidth.coerceAtMost(canvasHeight) / 2)
        val center = Offset(x = canvasWidth / 2, y = canvasHeight / 2)

        for (i in 0..300 step 5) {
            val length = canvasWidth / 50

            val angleInRadians = Math.toRadians(i.toDouble() - 240)

            val startX = center.x + (radius * cos(angleInRadians)).toFloat()
            val startY = center.y + (radius * sin(angleInRadians)).toFloat()

            val endX = center.x + ((radius - length) * cos(angleInRadians)).toFloat()
            val endY = center.y + ((radius - length) * sin(angleInRadians)).toFloat()

            drawLine(
                color = if (i % 30 == 0) onBackground else onBackgroundUnselected,
                start = Offset(x = startX, y = startY),
                end = Offset(x = endX, y = endY),
                strokeWidth = 1.dp.toPx(),
            )
        }

        val arrowLength = 8.dp.toPx() // Расстояние от конца окружности

        val angleInRadians = Math.toRadians(animatedValue.toDouble() - 240)
        val startX = center.x + ((radius - arrowLength) * cos(angleInRadians)).toFloat()
        val startY = center.y + ((radius - arrowLength) * sin(angleInRadians)).toFloat()
        val endX = center.x + (radius * cos(angleInRadians)).toFloat()
        val endY = center.y + (radius * sin(angleInRadians)).toFloat()

        val path = Path().apply {
            moveTo(startX, startY)
            lineTo(endX, endY)
            close()
        }

        drawPath(
            path = path,
            color = arrowColor,
            style = Stroke(width = 4.dp.toPx()),
        )
    }
}
