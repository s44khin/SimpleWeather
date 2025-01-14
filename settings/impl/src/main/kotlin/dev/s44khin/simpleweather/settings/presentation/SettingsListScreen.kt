package dev.s44khin.simpleweather.settings.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cached
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.resources.CoreStrings
import dev.s44khin.simpleweather.settings.presentation.widgets.SettingsListScrollableContent
import dev.s44khin.simpleweather.uikit.util.NavigationBarHeight
import dev.s44khin.simpleweather.uikit.util.Spacer
import dev.s44khin.simpleweather.uikit.util.StatusBarHeight
import dev.s44khin.simpleweather.uikit.widgets.BottomNavigationHeight
import dev.s44khin.simpleweather.uikit.widgets.TopNavigation
import dev.s44khin.simpleweather.uikit.widgets.TopNavigationAction
import dev.s44khin.simpleweather.uikit.widgets.TopNavigationHeight
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SettingsListScreen(
    viewModel: SettingsListViewModel = koinViewModel()
) {
    val state by viewModel.uiStateFlow.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Box {
        val scrollState = rememberScrollState()

        TopNavigation(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(CoreStrings.settings_label),
            scrollableState = scrollState,
            rightAction = TopNavigationAction(
                icon = Icons.Rounded.Cached,
                isVisible = state.isResetAvailable,
                onClick = { viewModel.onAction(SettingsListAction.OnResetAllSettingsClicked) }
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