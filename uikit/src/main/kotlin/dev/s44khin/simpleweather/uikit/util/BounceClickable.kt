package dev.s44khin.simpleweather.uikit.util

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInput

object BounceClickableDefaults {
    const val PRESSED_SCALE = 0.9f
}

fun Modifier.bounceClickable(
    enabled: Boolean = true,
    pressedScale: Float = BounceClickableDefaults.PRESSED_SCALE,
    onClick: () -> Unit,
) = composed {
    this.bounceClickable(
        enabled = enabled,
        pressedScale = pressedScale,
        interactionSource = remember { MutableInteractionSource() },
        onClick = onClick,
    )
}

fun Modifier.bounceClickable(
    interactionSource: MutableInteractionSource,
    enabled: Boolean = true,
    pressedScale: Float = BounceClickableDefaults.PRESSED_SCALE,
    onClick: () -> Unit,
) = composed {
    var isPressed by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isPressed) pressedScale else 1f,
        label = "bounceClickableScale",
    )

    this
        .scale(scale)
        .clickable(
            enabled = enabled,
            interactionSource = interactionSource,
            indication = null,
            onClick = onClick,
        )
        .pointerInput(isPressed) {
            awaitPointerEventScope {
                if (enabled) {
                    isPressed = if (isPressed) {
                        waitForUpOrCancellation()
                        false
                    } else {
                        awaitFirstDown(false)
                        true
                    }
                }
            }
        }
}