package dev.s44khin.simpleweather.uikit.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.AnimationState
import androidx.compose.animation.core.DecayAnimationSpec
import androidx.compose.animation.core.Spring.StiffnessLow
import androidx.compose.animation.core.animateDecay
import androidx.compose.animation.core.animateTo
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.TopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.util.clickableWithoutRipple
import dev.s44khin.simpleweather.uikit.util.ifNotNull
import dev.s44khin.simpleweather.uikit.util.ifThen
import dev.s44khin.simpleweather.utils.rememberMutableStateOf
import kotlin.math.abs

data class TopNavigationAction(
    val icon: ImageVector,
    val isVisible: Boolean = true,
    val onClick: () -> Unit,
)

val TopNavigationHeight = 64.dp

const val TopNavigationZIndex = 4f

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigation(
    modifier: Modifier = Modifier,
    title: String? = null,
    subTitle: String? = null,
    subTitleIsVisible: Boolean = false,
    leftAction: TopNavigationAction? = null,
    rightAction: TopNavigationAction? = null,
    scrollableState: ScrollableState? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    onTitleClick: (() -> Unit)? = null,
) {
    val heightOffsetLimit = with(LocalDensity.current) { -TopNavigationHeight.toPx() }

    SideEffect {
        if (scrollBehavior?.state?.heightOffsetLimit != heightOffsetLimit) {
            scrollBehavior?.state?.heightOffsetLimit = heightOffsetLimit
        }
    }

    val height = LocalDensity.current.run {
        (TopNavigationHeight.toPx() + (scrollBehavior?.state?.heightOffset ?: 0f)).toDp()
    }

    val animatedColor by animateColorAsState(
        targetValue = if (scrollableState?.canScrollBackward == false) {
            SimpleTheme.colors.root
        } else {
            SimpleTheme.colors.backgroundTransparent
        },
        label = "animatedColor",
        animationSpec = spring(stiffness = StiffnessLow)
    )

    var animatedAlpha by rememberMutableStateOf(0f)

    Box(
        modifier = modifier
            .ifNotNull(
                value = scrollBehavior,
                additionalCondition = { scrollBehavior?.isPinned?.not() == true }
            ) {
                draggable(
                    orientation = Orientation.Vertical,
                    state = rememberDraggableState { delta ->
                        it.state.heightOffset = it.state.heightOffset + delta
                    },
                    onDragStopped = { velocity ->
                        settleAppBar(
                            state = it.state,
                            velocity = velocity,
                            flingAnimationSpec = it.flingAnimationSpec,
                            snapAnimationSpec = it.snapAnimationSpec
                        )
                    }
                )
            }
            .background(color = animatedColor)
            .padding(horizontal = 4.dp)
            .statusBarsPadding()
            .height(height)
            .zIndex(TopNavigationZIndex)
    ) {
        if (leftAction != null) {
            AnimatedVisibility(
                modifier = Modifier
                    .alpha(animatedAlpha)
                    .align(alignment = Alignment.CenterStart),
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
                    .height(TopNavigationHeight)
                    .onGloballyPositioned {
                        animatedAlpha = (2 * (it.size.height / -heightOffsetLimit) - 1).coerceIn(0f..1f)
                    }
                    .alpha(animatedAlpha)
                    .fillMaxWidth(0.75f)
                    .align(Alignment.Center)
                    .ifThen(
                        condition = onTitleClick != null,
                        then = { clickableWithoutRipple { onTitleClick?.invoke() } }
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
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
                modifier = Modifier
                    .alpha(animatedAlpha)
                    .align(alignment = Alignment.CenterEnd),
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

@OptIn(ExperimentalMaterial3Api::class)
private suspend fun settleAppBar(
    state: TopAppBarState,
    velocity: Float,
    flingAnimationSpec: DecayAnimationSpec<Float>?,
    snapAnimationSpec: AnimationSpec<Float>?
): Velocity {
    // Check if the app bar is completely collapsed/expanded. If so, no need to settle the app bar,
    // and just return Zero Velocity.
    // Note that we don't check for 0f due to float precision with the collapsedFraction
    // calculation.
    if (state.collapsedFraction < 0.01f || state.collapsedFraction == 1f) {
        return Velocity.Zero
    }
    var remainingVelocity = velocity
    // In case there is an initial velocity that was left after a previous user fling, animate to
    // continue the motion to expand or collapse the app bar.
    if (flingAnimationSpec != null && abs(velocity) > 1f) {
        var lastValue = 0f
        AnimationState(
            initialValue = 0f,
            initialVelocity = velocity,
        )
            .animateDecay(flingAnimationSpec) {
                val delta = value - lastValue
                val initialHeightOffset = state.heightOffset
                state.heightOffset = initialHeightOffset + delta
                val consumed = abs(initialHeightOffset - state.heightOffset)
                lastValue = value
                remainingVelocity = this.velocity
                // avoid rounding errors and stop if anything is unconsumed
                if (abs(delta - consumed) > 0.5f) this.cancelAnimation()
            }
    }
    // Snap if animation specs were provided.
    if (snapAnimationSpec != null) {
        if (state.heightOffset < 0 &&
            state.heightOffset > state.heightOffsetLimit
        ) {
            AnimationState(initialValue = state.heightOffset).animateTo(
                if (state.collapsedFraction < 0.5f) {
                    0f
                } else {
                    state.heightOffsetLimit
                },
                animationSpec = snapAnimationSpec
            ) { state.heightOffset = value }
        }
    }

    return Velocity(0f, remainingVelocity)
}