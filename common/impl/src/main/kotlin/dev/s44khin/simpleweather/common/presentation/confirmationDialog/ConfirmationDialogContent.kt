package dev.s44khin.simpleweather.common.presentation.confirmationDialog

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.util.Spacer
import dev.s44khin.simpleweather.uikit.widgets.SimpleButton

@Composable
internal fun ColumnScope.ConfirmationDialogContent(
    state: ConfirmationDialogUiState,
    onAction: (ConfirmationDialogAction) -> Unit,
) {
    Spacer(height = 16.dp)

    if (state.title != null) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = state.title.resolve(),
            color = SimpleTheme.colors.onBackground,
            fontSize = 18.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }

    if (state.text != null) {
        Spacer(height = 8.dp)

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = state.text.resolve(),
            color = SimpleTheme.colors.onBackgroundUnselected,
            fontSize = 18.sp,
        )
    }

    if (state.icon != null) {
        Spacer(height = 32.dp)

        val rotateInfinityTransition = rememberInfiniteTransition(
            label = "rotateInfinityTransition"
        )

        val animatedRotation by rotateInfinityTransition.animateFloat(
            initialValue = 0f,
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(5_000)
            ),
            label = "animatedRotation"
        )

        Icon(
            modifier = Modifier
                .rotate(animatedRotation)
                .size(128.dp)
                .align(Alignment.CenterHorizontally),
            imageVector = state.icon,
            contentDescription = null,
            tint = SimpleTheme.colors.onBackgroundUnselected
        )
    }

    if (state.confirmButtonData != null) {
        Spacer(height = 32.dp)

        SimpleButton(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            onClick = { onAction(ConfirmationDialogAction.OnConfirmButtonClicked) },
            label = state.confirmButtonData.label.resolve(),
            contentColor = SimpleTheme.colors.onPrimary,
            backgroundColor = SimpleTheme.colors.primary
        )
    }

    if (state.cancelButtonLabel != null) {
        Spacer(height = 18.dp)

        SimpleButton(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            onClick = { onAction(ConfirmationDialogAction.OnCancelButtonClicked) },
            label = state.cancelButtonLabel.resolve(),
            contentColor = SimpleTheme.colors.divider,
            backgroundColor = SimpleTheme.colors.onBackground
        )
    }

    Spacer(height = 16.dp)
}