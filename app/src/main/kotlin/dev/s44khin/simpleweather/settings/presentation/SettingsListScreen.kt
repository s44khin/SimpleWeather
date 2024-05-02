package dev.s44khin.simpleweather.settings.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cached
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import dev.s44khin.simpleweather.R
import dev.s44khin.simpleweather.settings.presentation.widgets.SettingsListScrollableContent
import dev.s44khin.simpleweather.uikit.util.NavigationBarHeight
import dev.s44khin.simpleweather.uikit.util.Spacer
import dev.s44khin.simpleweather.uikit.util.StatusBarHeight
import dev.s44khin.simpleweather.uikit.widgets.BottomNavigationHeight
import dev.s44khin.simpleweather.uikit.widgets.TopNavigation
import dev.s44khin.simpleweather.uikit.widgets.TopNavigationAction
import dev.s44khin.simpleweather.uikit.widgets.TopNavigationHeight
import kotlinx.coroutines.launch

@Composable
fun SettingsListScreen() {
    val viewModel = hiltViewModel<SettingsListViewModel>()
    val state by viewModel.uiStateFlow.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Box {
        val scrollState = rememberScrollState()

        TopNavigation(
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(1f),
            title = stringResource(R.string.settings_label),
            scrollState = scrollState,
            rightAction = TopNavigationAction(
                icon = Icons.Rounded.Cached,
                onClick = {}
            ),
            onTitleClick = {
                coroutineScope.launch {
                    scrollState.animateScrollTo(0)
                }
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = scrollState)
        ) {
            Spacer(height = TopNavigationHeight + StatusBarHeight)

            SettingsListScrollableContent(
                state = state,
                onAction = viewModel::onAction
            )

            Spacer(height = BottomNavigationHeight + NavigationBarHeight + 48.dp)
        }
    }
}