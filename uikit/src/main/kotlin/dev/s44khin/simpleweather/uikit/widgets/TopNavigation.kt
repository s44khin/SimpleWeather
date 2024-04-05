package dev.s44khin.simpleweather.uikit.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.theme.defaultShape
import dev.s44khin.simpleweather.uikit.util.clickableWithoutRipple
import dev.s44khin.simpleweather.uikit.util.ifThen

data class TopNavigationAction(
    val icon: ImageVector,
    val onClick: () -> Unit,
)

@Composable
fun TopNavigation(
    modifier: Modifier = Modifier,
    title: String? = null,
    subTitle: String? = null,
    subTitleIsVisible: Boolean = true,
    leftAction: TopNavigationAction? = null,
    rightAction: TopNavigationAction? = null,
    onTitleClick: (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .background(
                color = SimpleTheme.colors.background,
                shape = RoundedCornerShape(bottomStart = defaultShape, bottomEnd = defaultShape),
            )
            .padding(horizontal = 4.dp)
            .statusBarsPadding()
            .height(56.dp)
    ) {
        if (leftAction != null) {
            IconButton(
                modifier = Modifier.align(alignment = Alignment.CenterStart),
                onClick = leftAction.onClick
            ) {
                Icon(
                    imageVector = leftAction.icon,
                    contentDescription = leftAction.icon.name,
                    tint = SimpleTheme.colors.onBackground
                )
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
                        fontSize = 18.sp,

                        )
                }

                AnimatedVisibility(
                    visible = subTitleIsVisible,
                    enter = fadeIn() + scaleIn(),
                    exit = fadeOut() + scaleOut(),
                ) {
                    Text(
                        text = subTitle ?: "",
                        fontSize = 12.sp,
                        color = SimpleTheme.colors.onBackgroundUnselected,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }

        if (rightAction != null) {
            IconButton(
                modifier = Modifier.align(alignment = Alignment.CenterEnd),
                onClick = rightAction.onClick
            ) {
                Icon(
                    imageVector = rightAction.icon,
                    contentDescription = rightAction.icon.name,
                    tint = SimpleTheme.colors.onBackground
                )
            }
        }
    }
}