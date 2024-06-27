package dev.s44khin.simpleweather.today.presentation.forecast.widgets

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.today.presentation.forecast.TodayForecastAction
import dev.s44khin.simpleweather.today.presentation.forecast.TodayForecastUiState
import dev.s44khin.simpleweather.uikit.util.NavigationBarHeight
import dev.s44khin.simpleweather.uikit.util.StatusBarHeight
import dev.s44khin.simpleweather.uikit.widgets.BottomNavigationHeight
import dev.s44khin.simpleweather.uikit.widgets.TopNavigationHeight

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun BoxScope.TodayForecastScrollableContent(
    state: TodayForecastUiState,
    lazyGridState: LazyGridState = rememberLazyGridState(),
    onAction: (TodayForecastAction) -> Unit,
) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = state.isRefreshing,
        onRefresh = { onAction(TodayForecastAction.OnPullToRefresh) }
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