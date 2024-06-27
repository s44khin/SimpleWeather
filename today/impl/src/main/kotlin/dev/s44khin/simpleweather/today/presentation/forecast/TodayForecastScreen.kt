package dev.s44khin.simpleweather.today.presentation.forecast

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import dev.s44khin.simpleweather.common.api.presentation.model.ScreenModeVo
import dev.s44khin.simpleweather.today.presentation.forecast.widgets.TodayForecastScrollableContent
import dev.s44khin.simpleweather.uikit.widgets.FullscreenLoader
import dev.s44khin.simpleweather.uikit.widgets.TopNavigation
import dev.s44khin.simpleweather.uikit.widgets.TopNavigationAction
import org.koin.androidx.compose.koinViewModel

/**
 * ScreenState: [TodayForecastScreenState]
 * UiState: [TodayForecastUiState]
 * Action: [TodayForecastAction]
 */
@Composable
internal fun TodayForecastScreen(
    viewModel: TodayForecastViewModel = koinViewModel(),
) {
    val state by viewModel.uiStateFlow.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        val lazyGridState = rememberLazyGridState()

        TopNavigation(
            modifier = Modifier.fillMaxWidth(),
            title = "Forecast",
            subTitle = state.locationName,
            subTitleIsVisible = state.locationName != null,
            scrollableState = lazyGridState,
            rightAction = TopNavigationAction(
                icon = Icons.Rounded.Search,
                onClick = { viewModel.onAction(TodayForecastAction.OnSearchClicked) }
            )
        )

        when (state.screenMode) {
            ScreenModeVo.Loading, ScreenModeVo.Content -> {
                TodayForecastScrollableContent(
                    state = state,
                    lazyGridState = lazyGridState,
                    onAction = viewModel::onAction
                )

                FullscreenLoader(
                    enabled = state.screenMode.isLoading
                )
            }

            ScreenModeVo.Error -> {

            }
        }
    }
}