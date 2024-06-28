package dev.s44khin.simpleweather.today.presentation.forecast.widgets

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.today.presentation.forecast.TodayForecastAction
import dev.s44khin.simpleweather.today.presentation.forecast.TodayForecastUiState
import dev.s44khin.simpleweather.uikit.util.NavigationBarHeight
import dev.s44khin.simpleweather.uikit.util.StatusBarHeight
import dev.s44khin.simpleweather.uikit.widgets.BottomNavigationHeight
import dev.s44khin.simpleweather.uikit.widgets.TopNavigationHeight

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
internal fun BoxScope.TodayForecastScrollableContent(
    state: TodayForecastUiState,
    lazyGridState: LazyGridState = rememberLazyGridState(),
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState()),
    onAction: (TodayForecastAction) -> Unit,
) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = state.isRefreshing,
        onRefresh = { onAction(TodayForecastAction.OnPullToRefresh) }
    )

    TodayForecastContent(
        modifier = Modifier
            .offset(y = with(LocalDensity.current) { scrollBehavior.state.heightOffset.toDp() })
            .fillMaxSize()
            .pullRefresh(
                state = pullRefreshState
            )
            .nestedScroll(
                connection = scrollBehavior.nestedScrollConnection
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