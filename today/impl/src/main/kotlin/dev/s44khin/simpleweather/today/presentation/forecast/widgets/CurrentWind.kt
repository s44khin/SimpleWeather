package dev.s44khin.simpleweather.today.presentation.forecast.widgets

import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.resources.CoreStrings
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecustCurrentWindVo
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.util.Spacer
import kotlin.math.cos
import kotlin.math.sin

@Composable
internal fun ColumnScope.CurrentWind(wind: ForecustCurrentWindVo) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(
            modifier = Modifier.weight(0.45f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = wind.speed.toString(),
                    style = MaterialTheme.typography.displayMedium,
                    color = SimpleTheme.colors.onBackground
                )

                Spacer(width = 8.dp)

                Column {
                    Text(
                        text = "M/s",
                        style = MaterialTheme.typography.bodySmall,
                        color = SimpleTheme.colors.onBackgroundUnselected
                    )

                    Text(
                        text = "Speed",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SimpleTheme.colors.onBackground,
                    )
                }
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                color = SimpleTheme.colors.divider,
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = wind.gust.toString(),
                    style = MaterialTheme.typography.displayMedium,
                    color = SimpleTheme.colors.onBackground
                )

                Spacer(width = 8.dp)

                Column {
                    Text(
                        text = "M/s",
                        style = MaterialTheme.typography.bodySmall,
                        color = SimpleTheme.colors.onBackgroundUnselected
                    )

                    Text(
                        text = "Gust",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SimpleTheme.colors.onBackground,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(0.1f))

        Compass(
            modifier = Modifier.weight(0.45f),
            degree = wind.degree,
            label = wind.label
        )
    }

    Text(
        text = stringResource(CoreStrings.wind),
        style = MaterialTheme.typography.bodyLarge,
        color = SimpleTheme.colors.onBackground,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
private fun Compass(
    degree: Float,
    label: String,
    modifier: Modifier = Modifier,
) {
    val onBackground = SimpleTheme.colors.onBackground
    val onBackgroundUnselected = SimpleTheme.colors.onBackgroundUnselected
    val divider = SimpleTheme.colors.divider
    val arrowColor = SimpleTheme.colors.primary
    val textMeasurer = rememberTextMeasurer()

    val infiniteTransition = rememberInfiniteTransition()
    val animatedDegree by infiniteTransition.animateFloat(
        initialValue = degree - 2f,
        targetValue = degree + 2f,
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(),
            repeatMode = RepeatMode.Reverse,
        )
    )

    val northResult = textMeasurer.measure(
        text = stringResource(CoreStrings.wind_north),
        style = MaterialTheme.typography.labelMedium,
    )

    val eastResult = textMeasurer.measure(
        text = stringResource(CoreStrings.wind_east),
        style = MaterialTheme.typography.labelMedium,
    )

    val southResult = textMeasurer.measure(
        text = stringResource(CoreStrings.wind_south),
        style = MaterialTheme.typography.labelMedium,
    )

    val westResult = textMeasurer.measure(
        text = stringResource(CoreStrings.wind_west),
        style = MaterialTheme.typography.labelMedium,
    )

    val labelResult = textMeasurer.measure(
        text = label,
        style = MaterialTheme.typography.titleMedium,
    )

    Canvas(modifier = modifier.aspectRatio(1f)) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        val radius = (canvasWidth.coerceAtMost(canvasHeight) / 2)
        val center = Offset(x = canvasWidth / 2, y = canvasHeight / 2)

        for (i in 0 until 360 step 5) {
            val length = if (i % 90 == 0) canvasWidth / 25 else canvasWidth / 50

            val angleInRadians = Math.toRadians(i.toDouble() - 90)

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

        val directions = listOf(
            northResult to 0,
            eastResult to 90,
            southResult to 180,
            westResult to 270,
        )

        for ((angleLabel, angle) in directions) {
            val angleInRadians = Math.toRadians(angle.toDouble() - 90)
            val x = center.x + ((radius - 20.dp.toPx()) * cos(angleInRadians)).toFloat() - angleLabel.size.width / 2f
            val y = center.y + ((radius - 20.dp.toPx()) * sin(angleInRadians)).toFloat() - angleLabel.size.height / 2f

            drawText(
                textLayoutResult = angleLabel,
                topLeft = Offset(x, y),
                color = onBackgroundUnselected
            )
        }

        val arrowLength = radius - 10.dp.toPx()
        val angleInRadians = Math.toRadians(animatedDegree.toDouble() - 90)
        val endX = center.x + (arrowLength * cos(angleInRadians)).toFloat()
        val endY = center.y + (arrowLength * sin(angleInRadians)).toFloat()
        val arrowHeadSize = 10.dp.toPx()

        val path = Path().apply {
            moveTo(center.x, center.y)
            lineTo(endX, endY)
            close()
        }

        drawPath(
            path = path,
            color = arrowColor,
            style = Stroke(width = 2.dp.toPx()),
        )

        val path2 = Path().apply {
            moveTo(endX, endY)

            lineTo(
                endX + (arrowHeadSize * cos(angleInRadians + Math.PI - 0.4)).toFloat(),
                endY + (arrowHeadSize * sin(angleInRadians + Math.PI - 0.4)).toFloat()
            )

            lineTo(
                endX + (arrowHeadSize * cos(angleInRadians - Math.PI + 0.4)).toFloat(),
                endY + (arrowHeadSize * sin(angleInRadians - Math.PI + 0.4)).toFloat()
            )

            lineTo(endX, endY)

            close()
        }

        drawPath(
            path = path2,
            color = arrowColor,
            style = Fill,
        )

        drawCircle(
            center = center,
            color = divider,
            radius = (canvasWidth.coerceAtMost(canvasHeight) / 5)
        )

        drawText(
            textLayoutResult = labelResult,
            topLeft = Offset(
                x = center.x - labelResult.size.width / 2f,
                y = center.y - labelResult.size.height / 2f,
            ),
            color = onBackground
        )
    }
}


