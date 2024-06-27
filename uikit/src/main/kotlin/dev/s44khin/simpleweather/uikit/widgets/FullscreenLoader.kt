package dev.s44khin.simpleweather.uikit.widgets

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.util.ifThen

@SuppressLint("ReturnFromAwaitPointerEventScope")
@Composable
fun FullscreenLoader(
    enabled: Boolean,
    modifier: Modifier = Modifier,
    backgroundColor: Color = SimpleTheme.colors.root,
    backgroundAlpha: Float = 1f,
    contentColor: Color = SimpleTheme.colors.primary,
) {
    val animatedAlpha by animateFloatAsState(
        targetValue = if (enabled) backgroundAlpha else 0f,
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = backgroundColor.copy(alpha = animatedAlpha))
            .ifThen(enabled) {
                pointerInput(Unit) {
                    awaitPointerEventScope {
                        while (true) {
                            awaitPointerEvent(pass = PointerEventPass.Initial)
                                .changes
                                .forEach(PointerInputChange::consume)
                        }
                    }
                }
            },
        contentAlignment = Alignment.Center,
    ) {
        AnimatedVisibility(
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut(),
            visible = enabled,
        ) {
            CircularProgressIndicator(
                color = contentColor,
            )
        }
    }
}
