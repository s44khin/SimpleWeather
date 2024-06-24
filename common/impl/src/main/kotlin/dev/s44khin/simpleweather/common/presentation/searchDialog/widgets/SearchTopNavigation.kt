package dev.s44khin.simpleweather.common.presentation.searchDialog.widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import dev.s44khin.simpleweather.common.presentation.widgets.Slide
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.util.Spacer
import dev.s44khin.simpleweather.uikit.widgets.TopNavigationZIndex

val SearchTopNavigationHeight = 66.dp

@Composable
fun SearchTopNavigation(
    query: String,
    scrollState: ScrollState? = null,
    onSearchInput: (String) -> Unit,
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

        SearchField(
            search = query,
            hint = "search",
            onValueChange = { onSearchInput(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            backgroundColor = animatedSlideColor
        )

        Spacer(height = 8.dp)
    }
}