package dev.s44khin.simpleweather.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme

@Composable
internal fun MainScreen() {
    val viewModel = hiltViewModel<MainViewModel>()

    SimpleTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = SimpleTheme.colors.root)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "state.value",
                color = SimpleTheme.colors.primary
            )
        }
    }
}