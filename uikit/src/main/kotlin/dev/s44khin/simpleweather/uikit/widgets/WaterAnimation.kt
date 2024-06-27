package dev.s44khin.simpleweather.uikit.widgets

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import kotlin.math.PI
import kotlin.math.sin

@Composable
fun WaterAnimation(
    modifier: Modifier = Modifier,
    waveHeightRatio: Float = 0.5f,
    waveAmplitude: Float = 20f,
    frontWaveColor: Color = SimpleTheme.colors.firtsWave,
    backWaveColor: Color = SimpleTheme.colors.secondWave,
    animationSpeed: Int = 4000
) {
    val finalWaveHeightRatio = waveHeightRatio.coerceIn(0.1f..0.9f)

    val infiniteTransition = rememberInfiniteTransition()
    val wave1Offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(animationSpeed, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val wave2Offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween((animationSpeed * 1.25).toInt(), easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Canvas(modifier) {
        val width = size.width
        val height = size.height
        val waterLevel = height * (1 - finalWaveHeightRatio) // Уровень воды на основе соотношения высоты воды
        val waveLength = width / 1.5f

        val path = Path()

        // Draw the back wave
        path.moveTo(0f, waterLevel)
        for (x in 0..width.toInt()) {
            val y = (waveAmplitude * sin((x * 2 * PI / waveLength) + wave2Offset * 2 * PI)).toFloat()
            path.lineTo(x.toFloat(), waterLevel + y)
        }
        path.lineTo(width, height)
        path.lineTo(0f, height)
        path.close()

        drawPath(
            path = path,
            color = backWaveColor,
            style = Fill
        )

        // Draw the front wave
        path.reset()
        path.moveTo(0f, waterLevel)
        for (x in 0..width.toInt()) {
            val y = (waveAmplitude * sin((x * 2 * PI / waveLength) + wave1Offset * 2 * PI)).toFloat()
            path.lineTo(x.toFloat(), waterLevel + y)
        }
        path.lineTo(width, height)
        path.lineTo(0f, height)
        path.close()

        drawPath(
            path = path,
            color = frontWaveColor,
            style = Fill
        )
    }
}
