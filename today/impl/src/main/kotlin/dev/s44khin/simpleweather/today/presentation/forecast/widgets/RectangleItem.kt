@file:OptIn(ExperimentalFoundationApi::class)

package dev.s44khin.simpleweather.today.presentation.forecast.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme

internal fun LazyGridScope.rectangleBox(
    key: Any? = null,
    contentType: Any? = null,
    contentPadding: PaddingValues = PaddingValues(),
    content: @Composable BoxScope.() -> Unit,
) {
    item(
        key = key,
        contentType = contentType,
        span = { GridItemSpan(maxLineSpan) },
    ) {
        Box(
            modifier = Modifier
                .aspectRatio(2f)
                .background(
                    color = SimpleTheme.colors.background,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(contentPadding)
                .animateItemPlacement(),
            content = content,
        )
    }
}

internal fun LazyGridScope.rectangleColumn(
    key: Any? = null,
    contentType: Any? = null,
    contentPadding: PaddingValues = PaddingValues(),
    content: @Composable ColumnScope.() -> Unit,
) {
    item(
        key = key,
        contentType = contentType,
        span = { GridItemSpan(maxLineSpan) },
    ) {
        Column(
            modifier = Modifier
                .aspectRatio(2f)
                .background(
                    color = SimpleTheme.colors.background,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(contentPadding)
                .animateItemPlacement(),
            content = content,
        )
    }
}

internal fun LazyGridScope.rectangleRow(
    key: Any? = null,
    contentType: Any? = null,
    contentPadding: PaddingValues = PaddingValues(),
    content: @Composable RowScope.() -> Unit,
) {
    item(
        key = key,
        contentType = contentType,
        span = { GridItemSpan(maxLineSpan) },
    ) {
        Row(
            modifier = Modifier
                .aspectRatio(2f)
                .background(
                    color = SimpleTheme.colors.background,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(contentPadding)
                .animateItemPlacement(),
            content = content,
        )
    }
}