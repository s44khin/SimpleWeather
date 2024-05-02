package dev.s44khin.simpleweather.today.presentation.forecast

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.s44khin.simpleweather.common.util.rememberMutableStateOf
import dev.s44khin.simpleweather.uikit.util.Spacer
import dev.s44khin.simpleweather.uikit.widgets.TopNavigation

@Composable
fun TodayForecastScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        val viewModel = hiltViewModel<TodayForecastViewModel>()
        var subTitle by rememberMutableStateOf(value = false)

        TopNavigation(
            modifier = Modifier.fillMaxWidth(),
            title = "Forecast",
            subTitle = "Иркутск",
            subTitleIsVisible = subTitle,
        )

        Spacer(height = 16.dp)

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center,
        ) {
            Button(onClick = { }) {
                Text(text = "Heasda s")
            }
        }
    }
}