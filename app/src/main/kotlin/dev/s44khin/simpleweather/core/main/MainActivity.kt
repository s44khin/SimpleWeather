package dev.s44khin.simpleweather.core.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.s44khin.simpleweather.core.navigation.NavigationCommandHandler
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val viewModel = hiltViewModel<MainViewModel>()
            val navHostController = rememberNavController()

            NavigationCommandHandler(
                navController = navHostController,
                commands = viewModel.navigationCommand,
            )

            SimpleTheme {
                MainScreen(
                    navHostController = navHostController,
                    onAction = viewModel::onAction,
                )
            }
        }
    }
}