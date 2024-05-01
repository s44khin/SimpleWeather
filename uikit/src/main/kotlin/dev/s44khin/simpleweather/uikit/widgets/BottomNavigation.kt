package dev.s44khin.simpleweather.uikit.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme

val BottomNavigationHeight = 80.dp

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = modifier
            .background(color = SimpleTheme.colors.backgroundTransparent)
            .navigationBarsPadding()
            .height(BottomNavigationHeight),
        content = content,
    )
}