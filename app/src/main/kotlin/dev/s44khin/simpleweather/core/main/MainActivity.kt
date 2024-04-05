package dev.s44khin.simpleweather.core.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import dev.s44khin.simpleweather.common.util.LocalViewModelFactory
import dev.s44khin.simpleweather.common.util.daggerViewModel
import dev.s44khin.simpleweather.core.di.AppComponent
import dev.s44khin.simpleweather.core.di.AppViewModelFactory
import dev.s44khin.simpleweather.core.di.DaggerAppComponent
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navHostController: NavHostController

    @Inject
    lateinit var appViewModelFactory: AppViewModelFactory

    lateinit var appComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appComponent = DaggerAppComponent.builder()
            .addContext(this)
            .build()

        appComponent

        appComponent.inject(this)

        enableEdgeToEdge()

        setContent {
            CompositionLocalProvider(LocalViewModelFactory provides appViewModelFactory) {
                val viewModel = daggerViewModel<MainViewModel>()

                MainScreen(
                    navHostController = navHostController,
                    onAction = viewModel::onAction,
                )
            }
        }
    }
}