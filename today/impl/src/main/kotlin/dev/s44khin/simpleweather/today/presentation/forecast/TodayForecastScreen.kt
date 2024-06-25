package dev.s44khin.simpleweather.today.presentation.forecast

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.s44khin.simpleweather.uikit.util.NavigationBarHeight
import dev.s44khin.simpleweather.uikit.util.Spacer
import dev.s44khin.simpleweather.uikit.util.StatusBarHeight
import dev.s44khin.simpleweather.uikit.widgets.BottomNavigationHeight
import dev.s44khin.simpleweather.uikit.widgets.TopNavigation
import dev.s44khin.simpleweather.uikit.widgets.TopNavigationAction
import dev.s44khin.simpleweather.uikit.widgets.TopNavigationHeight
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun TodayForecastScreen(
    viewModel: TodayForecastViewModel = koinViewModel(),
) {
    val state by viewModel.uiStateFlow.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        val scrollState = rememberScrollState()

        TopNavigation(
            modifier = Modifier.fillMaxWidth(),
            title = "Forecast",
            subTitle = state.locationName,
            subTitleIsVisible = state.locationName != null,
            scrollState = scrollState,
            rightAction = TopNavigationAction(
                icon = Icons.Rounded.Search,
                onClick = { viewModel.onAction(TodayForecastAction.OnSearchClicked) }
            )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = scrollState)
        ) {
            Spacer(height = TopNavigationHeight + StatusBarHeight + 16.dp)

            repeat(100) {
                Text(text = "$it")
                Spacer(height = 16.dp)
            }

            Spacer(height = BottomNavigationHeight + NavigationBarHeight + 16.dp)
        }
    }
}