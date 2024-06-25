package dev.s44khin.simpleweather.today.presentation.forecast

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.today.presentation.forecast.widgets.TodayForecastContent
import dev.s44khin.simpleweather.uikit.util.NavigationBarHeight
import dev.s44khin.simpleweather.uikit.util.StatusBarHeight
import dev.s44khin.simpleweather.uikit.widgets.BottomNavigationHeight
import dev.s44khin.simpleweather.uikit.widgets.TopNavigation
import dev.s44khin.simpleweather.uikit.widgets.TopNavigationAction
import dev.s44khin.simpleweather.uikit.widgets.TopNavigationHeight
import org.koin.androidx.compose.koinViewModel

/**
 * ScreenState: [TodayForecastScreenState]
 * UiState: [TodayForecastUiState]
 * Action: [TodayForecastAction]
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun TodayForecastScreen(
    viewModel: TodayForecastViewModel = koinViewModel(),
) {
    val state by viewModel.uiStateFlow.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        val lazyGridState = rememberLazyGridState()
        val pullRefreshState = rememberPullRefreshState(
            refreshing = state.isRefreshing,
            onRefresh = { viewModel.onAction(TodayForecastAction.OnPullToRefresh) }
        )

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

        TodayForecastContent(
            modifier = Modifier
                .fillMaxSize()
                .pullRefresh(
                    state = pullRefreshState
                ),
            uiState = state,
            lazyGridState = lazyGridState,
            contentPadding = PaddingValues(
                top = TopNavigationHeight + StatusBarHeight + 16.dp,
                bottom = BottomNavigationHeight + NavigationBarHeight + 16.dp,
                start = 16.dp,
                end = 16.dp,
            )
        )

        PullRefreshIndicator(
            modifier = Modifier
                .padding(top = TopNavigationHeight + StatusBarHeight)
                .align(Alignment.TopCenter),
            refreshing = state.isRefreshing,
            state = pullRefreshState,
            scale = true,
        )
    }
}