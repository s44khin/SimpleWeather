package dev.s44khin.simpleweather.settings.presentation.widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.common.api.presentation.ThemeVo
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme

@Composable
internal fun ThemeItem(
    theme: ThemeVo,
    selected: Boolean,
    modifier: Modifier = Modifier,
) {
    val animatedColor by animateColorAsState(
        targetValue = if (selected) {
            SimpleTheme.colors.primary
        } else {
            SimpleTheme.colors.onBackgroundUnselected
        },
        label = "animatedColor"
    )

    val animatedTextColor by animateColorAsState(
        targetValue = if (selected) {
            SimpleTheme.colors.onPrimary
        } else {
            SimpleTheme.colors.onBackgroundUnselected
        },
        label = "animatedTextColor"
    )

    val animatedChipColor by animateColorAsState(
        targetValue = if (selected) {
            SimpleTheme.colors.primary
        } else {
            SimpleTheme.colors.background
        },
        label = "animatedChipColor"
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Icon(
            modifier = Modifier.size(32.dp),
            imageVector = theme.imageVector,
            tint = animatedColor,
            contentDescription = null,
        )

        Box(
            modifier = Modifier
                .background(color = animatedChipColor, shape = CircleShape)
                .padding(vertical = 2.dp, horizontal = 4.dp)
        ) {
            Text(
                text = theme.name,
                color = animatedTextColor,
                maxLines = 1,
            )
        }
    }
}