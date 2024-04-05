package dev.s44khin.simpleweather.uikit.widgets

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme

@Composable
fun RowScope.BottomNavigationItem(
    selected: Boolean,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
) {
    NavigationBarItem(
        modifier = modifier,
        selected = selected,
        icon = { Icon(imageVector = icon, contentDescription = icon.name) },
        enabled = enabled,
        label = { Text(text = label) },
        colors = NavigationBarItemDefaults.colors(
            unselectedTextColor = SimpleTheme.colors.onBackgroundUnselected,
            selectedTextColor = SimpleTheme.colors.onBackground,
            unselectedIconColor = SimpleTheme.colors.onBackgroundUnselected,
            indicatorColor = SimpleTheme.colors.primary,
            selectedIconColor = SimpleTheme.colors.onBackground
        ),
        interactionSource = interactionSource,
        onClick = onClick
    )
}