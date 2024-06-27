@file:OptIn(ExperimentalFoundationApi::class)

package dev.s44khin.simpleweather.today.presentation.forecast.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.today.presentation.forecast.model.DangerLevel
import dev.s44khin.simpleweather.today.presentation.forecast.model.color
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.util.ifThen

internal fun LazyGridScope.rectangleBox(
    modifier: Modifier = Modifier,
    key: Any? = null,
    contentType: Any? = null,
    contentPadding: PaddingValues = PaddingValues(),
    dangerLevel: DangerLevel? = null,
    content: @Composable BoxScope.() -> Unit,
) {
    item(
        key = key,
        contentType = contentType,
        span = { GridItemSpan(maxLineSpan) },
    ) {
        Box(
            modifier = modifier
                .animateItemPlacement()
                .aspectRatio(2f)
                .background(
                    color = SimpleTheme.colors.background,
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .padding(contentPadding)
                .ifThen(dangerLevel != null) {
                    border(
                        width = 2.dp,
                        shape = RoundedCornerShape(16.dp),
                        color = dangerLevel.color,
                    )
                },
            content = content,
        )
    }
}

internal fun LazyGridScope.rectangleColumn(
    modifier: Modifier = Modifier,
    key: Any? = null,
    contentType: Any? = null,
    contentPadding: PaddingValues = PaddingValues(),
    dangerLevel: DangerLevel? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    item(
        key = key,
        contentType = contentType,
        span = { GridItemSpan(maxLineSpan) },
    ) {
        Column(
            modifier = modifier
                .animateItemPlacement()
                .aspectRatio(2f)
                .background(
                    color = SimpleTheme.colors.background,
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .padding(contentPadding)
                .ifThen(dangerLevel != null) {
                    border(
                        width = 2.dp,
                        shape = RoundedCornerShape(16.dp),
                        color = dangerLevel.color,
                    )
                },
            content = content,
        )
    }
}

internal fun LazyGridScope.rectangleRow(
    modifier: Modifier = Modifier,
    key: Any? = null,
    contentType: Any? = null,
    contentPadding: PaddingValues = PaddingValues(),
    dangerLevel: DangerLevel? = null,
    content: @Composable RowScope.() -> Unit,
) {
    item(
        key = key,
        contentType = contentType,
        span = { GridItemSpan(maxLineSpan) },
    ) {
        Row(
            modifier = modifier
                .animateItemPlacement()
                .aspectRatio(2f)
                .background(
                    color = SimpleTheme.colors.background,
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .padding(contentPadding)
                .ifThen(dangerLevel != null) {
                    border(
                        width = 2.dp,
                        shape = RoundedCornerShape(16.dp),
                        color = dangerLevel.color,
                    )
                },

            content = content,
        )
    }
}