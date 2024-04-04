package dev.s44khin.simpleweather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme

@Composable
internal fun MainScreen() {
    SimpleTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = SimpleTheme.colors.root)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Hello world!",
                color = SimpleTheme.colors.primary
            )
        }
    }
}