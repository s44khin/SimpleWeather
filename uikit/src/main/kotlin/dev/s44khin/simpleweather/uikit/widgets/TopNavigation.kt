package dev.s44khin.simpleweather.uikit.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring.StiffnessLow
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.util.clickableWithoutRipple
import dev.s44khin.simpleweather.uikit.util.ifThen

data class TopNavigationAction(
    val icon: ImageVector,
    val isVisible: Boolean = true,
    val onClick: () -> Unit,
)

val TopNavigationHeight = 64.dp

const val TopNavigationZIndex = 4f

@Composable
fun TopNavigation(
    modifier: Modifier = Modifier,
    title: String? = null,
    subTitle: String? = null,
    subTitleIsVisible: Boolean = false,
    leftAction: TopNavigationAction? = null,
    rightAction: TopNavigationAction? = null,
    scrollableState: ScrollableState? = null,
    onTitleClick: (() -> Unit)? = null,
) {
    val animatedColor by animateColorAsState(
        targetValue = if (scrollableState?.canScrollBackward == false) {
            SimpleTheme.colors.root
        } else {
            SimpleTheme.colors.backgroundTransparent
        },
        label = "animatedColor",
        animationSpec = spring(stiffness = StiffnessLow)
    )

    Box(
        modifier = modifier
            .background(color = animatedColor)
            .padding(horizontal = 4.dp)
            .statusBarsPadding()
            .height(TopNavigationHeight)
            .zIndex(TopNavigationZIndex)
    ) {
        if (leftAction != null) {
            AnimatedVisibility(
                modifier = Modifier.align(alignment = Alignment.CenterStart),
                visible = leftAction.isVisible,
                enter = fadeIn() + scaleIn(),
                exit = fadeOut() + scaleOut(),
            ) {
                IconButton(onClick = leftAction.onClick) {
                    Icon(
                        imageVector = leftAction.icon,
                        contentDescription = leftAction.icon.name,
                        tint = SimpleTheme.colors.onBackground
                    )
                }
            }
        }

        if (title != null || subTitle != null) {
            Column(
                modifier = Modifier
                    .animateContentSize()
                    .fillMaxWidth(0.75f)
                    .align(Alignment.Center)
                    .ifThen(
                        condition = onTitleClick != null,
                        then = { clickableWithoutRipple { onTitleClick?.invoke() } }
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                if (title != null) {
                    Text(
                        text = title,
                        color = SimpleTheme.colors.onBackground,
                        style = MaterialTheme.typography.titleLarge,
                    )
                }

                AnimatedVisibility(
                    visible = subTitleIsVisible,
                    enter = fadeIn() + scaleIn(),
                    exit = fadeOut() + scaleOut(),
                ) {
                    Text(
                        text = subTitle ?: "",
                        color = SimpleTheme.colors.onBackgroundUnselected,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }

        if (rightAction != null) {
            AnimatedVisibility(
                modifier = Modifier.align(alignment = Alignment.CenterEnd),
                visible = rightAction.isVisible,
                enter = fadeIn() + scaleIn(),
                exit = fadeOut() + scaleOut(),
            ) {
                IconButton(onClick = rightAction.onClick) {
                    Icon(
                        imageVector = rightAction.icon,
                        contentDescription = rightAction.icon.name,
                        tint = SimpleTheme.colors.onBackground
                    )
                }
            }
        }
    }
}