package dev.s44khin.simpleweather.uikit.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme

@Composable
fun DialogLayoutBox(
    modifier: Modifier = Modifier,
    backgroundColor: Color = SimpleTheme.colors.root,
    shape: Shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    contentAlignment: Alignment = Alignment.TopStart,
    propagateMinConstraints: Boolean = false,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .statusBarsPadding()
            .shadow(elevation = 8.dp)
            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape = shape,
            )
            .clip(shape),
        contentAlignment = contentAlignment,
        propagateMinConstraints = propagateMinConstraints,
        content = content,
    )
}