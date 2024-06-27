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
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme

internal fun LazyGridScope.squareBox(
    modifier: Modifier = Modifier,
    key: Any? = null,
    contentType: Any? = null,
    contentPadding: PaddingValues = PaddingValues(),
    content: @Composable BoxScope.() -> Unit,
) {
    item(
        key = key,
        contentType = contentType,
    ) {
        Box(
            modifier = modifier
                .animateItemPlacement()
                .aspectRatio(1f)
                .background(
                    color = SimpleTheme.colors.background,
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .padding(contentPadding),
            content = content,
        )
    }
}

internal fun LazyGridScope.squareColumn(
    modifier: Modifier = Modifier,
    key: Any? = null,
    contentType: Any? = null,
    contentPadding: PaddingValues = PaddingValues(),
    content: @Composable ColumnScope.() -> Unit,
) {
    item(
        key = key,
        contentType = contentType,
    ) {
        Column(
            modifier = modifier
                .animateItemPlacement()
                .aspectRatio(1f)
                .background(
                    color = SimpleTheme.colors.background,
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .padding(contentPadding),
            content = content,
        )
    }
}

internal fun LazyGridScope.squareRow(
    modifier: Modifier = Modifier,
    key: Any? = null,
    contentType: Any? = null,
    contentPadding: PaddingValues = PaddingValues(),
    content: @Composable RowScope.() -> Unit,
) {
    item(
        key = key,
        contentType = contentType,
    ) {
        Row(
            modifier = modifier
                .animateItemPlacement()
                .aspectRatio(1f)
                .background(
                    color = SimpleTheme.colors.background,
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .padding(contentPadding),
            content = content,
        )
    }
}