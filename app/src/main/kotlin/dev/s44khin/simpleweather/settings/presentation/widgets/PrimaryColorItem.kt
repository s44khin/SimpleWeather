package dev.s44khin.simpleweather.settings.presentation.widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.common.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.util.clickableWithoutRipple
import dev.s44khin.simpleweather.uikit.util.ifThen

@Composable
fun PrimaryColorItem(
    primaryColorVo: PrimaryColorVo,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val animatedColor by animateColorAsState(
        targetValue = if (selected) SimpleTheme.colors.divider else SimpleTheme.colors.background,
        label = "animatedColor"
    )

    Column(
        modifier = modifier
            .clickableWithoutRipple { onClick() }
            .ifThen(selected) {
                border(
                    color = animatedColor,
                    width = 1.dp,
                    shape = RoundedCornerShape(8.dp)
                )
            }
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(
            modifier = Modifier
                .size(48.dp)
                .background(
                    color = primaryColorVo.light,
                    shape = CircleShape
                )
                .clip(shape = CircleShape)
        )

        Spacer(
            modifier = Modifier
                .size(48.dp)
                .background(
                    color = primaryColorVo.dark,
                    shape = CircleShape
                )
                .clip(shape = CircleShape)
        )
    }
}