package dev.s44khin.simpleweather.today.presentation.forecast.widgets

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.resources.CoreStrings
import dev.s44khin.simpleweather.today.presentation.forecast.model.ForecastCurrentUviVo
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme

@Composable
internal fun ColumnScope.UvIndex(
    uvindex: ForecastCurrentUviVo,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = uvindex.value.toString(),
            style = MaterialTheme.typography.headlineMedium,
            color = SimpleTheme.colors.onBackground
        )

        Text(
            text = uvindex.type.message,
            style = MaterialTheme.typography.bodyLarge,
            color = SimpleTheme.colors.onBackgroundUnselected
        )
    }

    UVIndexLine(
        uviValue = uvindex.value
    )

    Text(
        text = stringResource(CoreStrings.uvindex),
        style = MaterialTheme.typography.bodyLarge,
        color = SimpleTheme.colors.onBackground,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
private fun UVIndexLine(uviValue: Float) {
    val pointColor = SimpleTheme.colors.pointColor
    val pointBorderColor = SimpleTheme.colors.pointBorderColor


    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(12.dp)
    ) {
        val lineWidth = size.width
        val startPoint = Offset(0f, 12.dp.toPx() / 2f)
        val endPoint = Offset(lineWidth, 12.dp.toPx() / 2f)

        drawLine(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    Color(0xff91c703),
                    Color(0xffffb800),
                    Color(0xffff8d02),
                    Color(0xffff3c00),
                    Color(0xff9936d4)
                )
            ),
            start = startPoint,
            end = endPoint,
            strokeWidth = 8.dp.toPx(),
            cap = StrokeCap.Round,
        )

        val pointX = lineWidth * (uviValue / 11f)

        val pointRadius = 6.5.dp.toPx()
        val point2Radius = 4.dp.toPx()

        drawCircle(
            color = pointBorderColor,
            radius = pointRadius,
            center = Offset(pointX, startPoint.y)
        )

        drawCircle(
            color = pointColor,
            radius = point2Radius,
            center = Offset(pointX, startPoint.y)
        )
    }
}
