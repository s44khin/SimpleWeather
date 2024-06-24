package dev.s44khin.simpleweather.core.main

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import dev.s44khin.simpleweather.common.presentation.model.ThemeVo
import dev.s44khin.simpleweather.core.navigation.NavigationCommandHandler
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel = koinViewModel<MainViewModel>()
            val navHostController = rememberNavController()
            val state by viewModel.uiStateFlow.collectAsState()

            NavigationCommandHandler(
                navController = navHostController,
                commands = viewModel.navigationCommand,
            )

            LaunchedEffect(state.theme) {
                val transparent = Color.TRANSPARENT

                enableEdgeToEdge(
                    statusBarStyle = when (state.theme) {
                        ThemeVo.System -> SystemBarStyle.auto(transparent, transparent)
                        ThemeVo.Dark -> SystemBarStyle.dark(transparent)
                        ThemeVo.Light -> SystemBarStyle.light(transparent, transparent)
                    }
                )
            }

            SimpleTheme(
                primaryLightColor = state.color.light,
                primaryDarkColor = state.color.dark,
                transparent = state.transparent,
                isDarkTheme = when (state.theme) {
                    ThemeVo.System -> isSystemInDarkTheme()
                    ThemeVo.Dark -> true
                    ThemeVo.Light -> false
                }
            ) {
                MainScreen(
                    state = state,
                    navHostController = navHostController,
                    onAction = viewModel::onAction,
                )
            }
        }
    }
}