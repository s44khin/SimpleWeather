package dev.s44khin.simpleweather.settings.presentation.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.common.presentation.model.PrimaryColorVo
import dev.s44khin.simpleweather.uikit.util.clickableWithoutRipple

@Composable
fun PrimaryColorItem(
    primaryColorVo: PrimaryColorVo,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .background(
                color = primaryColorVo.primary,
                shape = CircleShape
            )
            .clip(shape = CircleShape)
            .clickableWithoutRipple { onClick.invoke() }
    ) {
        AnimatedVisibility(
            modifier = Modifier.align(Alignment.Center),
            visible = selected,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut()
        ) {
            Icon(
                imageVector = Icons.Rounded.Done,
                tint = primaryColorVo.onPrimary,
                contentDescription = null,
            )
        }
    }
}