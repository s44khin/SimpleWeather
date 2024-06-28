@file:OptIn(ExperimentalFoundationApi::class)

package dev.s44khin.simpleweather.today.presentation.forecast.widgets

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.util.ifThen

internal fun LazyGridScope.rectangleBox(
    modifier: Modifier = Modifier,
    key: Any? = null,
    contentType: Any? = null,
    contentPadding: PaddingValues = PaddingValues(),
    borderColor: @Composable (() -> Color?)? = null,
    content: @Composable BoxScope.() -> Unit,
) {
    item(
        key = key,
        contentType = contentType,
        span = { GridItemSpan(maxLineSpan) },
    ) {
        val infiniteTransition = rememberInfiniteTransition()
        val animatedBorderWidth by infiniteTransition.animateFloat(
            initialValue = 50f,
            targetValue = 300f,
            animationSpec = infiniteRepeatable(
                animation = tween(1_000, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            )
        )

        Box(
            modifier = modifier
                .animateItemPlacement()
                .background(
                    color = SimpleTheme.colors.background,
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .ifThen(borderColor?.invoke() != null) {
                    border(
                        width = (animatedBorderWidth / 100f).dp,
                        shape = RoundedCornerShape(16.dp),
                        color = borderColor?.invoke() ?: Color.White,
                    )
                }
                .padding(contentPadding),
            content = content,
        )
    }
}

internal fun LazyGridScope.rectangleColumn(
    modifier: Modifier = Modifier,
    key: Any? = null,
    contentType: Any? = null,
    contentPadding: PaddingValues = PaddingValues(),
    borderColor: @Composable (() -> Color?)? = null,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable ColumnScope.() -> Unit,
) {
    item(
        key = key,
        contentType = contentType,
        span = { GridItemSpan(maxLineSpan) },
    ) {
        val infiniteTransition = rememberInfiniteTransition()
        val animatedBorderWidth by infiniteTransition.animateFloat(
            initialValue = 50f,
            targetValue = 300f,
            animationSpec = infiniteRepeatable(
                animation = tween(1_000, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            )
        )

        Column(
            modifier = modifier
                .animateItemPlacement()
                .background(
                    color = SimpleTheme.colors.background,
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .ifThen(borderColor?.invoke() != null) {
                    border(
                        width = (animatedBorderWidth / 100f).dp,
                        shape = RoundedCornerShape(16.dp),
                        color = borderColor?.invoke() ?: Color.White,
                    )
                }
                .padding(contentPadding),
            verticalArrangement = verticalArrangement,
            horizontalAlignment = horizontalAlignment,
            content = content,
        )
    }
}

internal fun LazyGridScope.rectangleRow(
    modifier: Modifier = Modifier,
    key: Any? = null,
    contentType: Any? = null,
    contentPadding: PaddingValues = PaddingValues(),
    borderColor: @Composable (() -> Color?)? = null,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    content: @Composable RowScope.() -> Unit,
) {
    item(
        key = key,
        contentType = contentType,
        span = { GridItemSpan(maxLineSpan) },
    ) {
        val infiniteTransition = rememberInfiniteTransition()
        val animatedBorderWidth by infiniteTransition.animateFloat(
            initialValue = 50f,
            targetValue = 300f,
            animationSpec = infiniteRepeatable(
                animation = tween(1_000, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            )
        )

        Row(
            modifier = modifier
                .animateItemPlacement()
                .background(
                    color = SimpleTheme.colors.background,
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .ifThen(borderColor?.invoke() != null) {
                    border(
                        width = (animatedBorderWidth / 100f).dp,
                        shape = RoundedCornerShape(16.dp),
                        color = borderColor?.invoke() ?: Color.White,
                    )
                }
                .padding(contentPadding),
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = verticalAlignment,
            content = content,
        )
    }
}

internal fun LazyGridScope.transparentReactangleRow(
    modifier: Modifier = Modifier,
    key: Any? = null,
    contentType: Any? = null,
    contentPadding: PaddingValues = PaddingValues(),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    content: @Composable RowScope.() -> Unit,
) {
    item(
        key = key,
        contentType = contentType,
        span = { GridItemSpan(maxLineSpan) },
    ) {
        Row(
            modifier = modifier.padding(contentPadding),
            verticalAlignment = verticalAlignment,
            horizontalArrangement = horizontalArrangement,
        ) {
            content()
        }
    }
}
