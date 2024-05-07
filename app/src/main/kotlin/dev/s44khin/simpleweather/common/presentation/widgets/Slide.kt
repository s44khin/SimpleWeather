package dev.s44khin.simpleweather.common.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme

@Composable
fun Slide(
    modifier: Modifier = Modifier,
    color: Color = SimpleTheme.colors.background,
) {
    Spacer(
        modifier = modifier
            .background(color = color, shape = CircleShape)
            .height(8.dp)
            .width(48.dp)
    )
}