package dev.s44khin.simpleweather.settings.presentation.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DarkMode
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.util.Spacer

@Composable
fun ColorFirstColumn(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(8.dp),
    ) {
        Spacer(height = 8.dp)

        Icon(
            modifier = Modifier.size(32.dp),
            imageVector = Icons.Rounded.LightMode,
            contentDescription = null,
            tint = SimpleTheme.colors.onBackgroundUnselected,
        )

        Spacer(height = 24.dp)

        Icon(
            modifier = Modifier.size(32.dp),
            imageVector = Icons.Rounded.DarkMode,
            contentDescription = null,
            tint = SimpleTheme.colors.onBackgroundUnselected,
        )

        Spacer(height = 8.dp)
    }
}