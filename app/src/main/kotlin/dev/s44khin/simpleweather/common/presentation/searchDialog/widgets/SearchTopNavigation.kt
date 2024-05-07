package dev.s44khin.simpleweather.common.presentation.searchDialog.widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import dev.s44khin.simpleweather.R
import dev.s44khin.simpleweather.common.presentation.widgets.Slide
import dev.s44khin.simpleweather.common.util.rememberMutableStateOf
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.util.Spacer
import dev.s44khin.simpleweather.uikit.widgets.TopNavigationZIndex

val SearchTopNavigationHeight = 80.dp
private val _SearchTopNavigationHeight = 56.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTopNavigation(
    scrollState: ScrollState? = null,
    onCloseClicked: () -> Unit,
) {
    val animatedColor by animateColorAsState(
        targetValue = if (scrollState?.value in 0..50) {
            SimpleTheme.colors.root
        } else {
            SimpleTheme.colors.backgroundTransparent
        },
        label = "animatedColor",
        animationSpec = spring(stiffness = Spring.StiffnessLow)
    )

    val animatedSlideColor by animateColorAsState(
        targetValue = if (scrollState?.value in 0..50) {
            SimpleTheme.colors.background
        } else {
            SimpleTheme.colors.divider
        },
        label = "animatedSlideColor",
        animationSpec = spring(stiffness = Spring.StiffnessLow)
    )

    Column(
        modifier = Modifier
            .background(color = animatedColor)
            .fillMaxWidth()
            .zIndex(TopNavigationZIndex)
    ) {
        Spacer(height = 8.dp)

        Slide(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = animatedSlideColor,
        )

        Spacer(height = 8.dp)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(_SearchTopNavigationHeight)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .align(Alignment.Center),
                text = stringResource(R.string.search_dialog_title),
                color = SimpleTheme.colors.onBackground,
                fontSize = 18.sp,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                maxLines = 1,
            )

            IconButton(
                modifier = Modifier.align(Alignment.CenterEnd),
                onClick = onCloseClicked,
            ) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = null,
                    tint = SimpleTheme.colors.onBackground,
                )
            }
        }

        var value by rememberMutableStateOf(value = "")

        SearchField(
            search = value,
            hint = "search",
            onValueChange = { value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            backgroundColor = animatedSlideColor
        )

        Spacer(height = 16.dp)
    }
}