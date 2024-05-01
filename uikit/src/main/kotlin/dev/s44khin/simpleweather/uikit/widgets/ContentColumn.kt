package dev.s44khin.simpleweather.uikit.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.theme.defaultShape

@Composable
inline fun ContentColumn(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .padding(bottom = BottomNavigationHeight + 8.dp)
            .navigationBarsPadding()
            .background(
                color = SimpleTheme.colors.background,
                shape = RoundedCornerShape(defaultShape)
            )
            .clip(RoundedCornerShape(defaultShape))
            .then(modifier),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
        content = content,
    )
}