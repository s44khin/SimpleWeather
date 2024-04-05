package dev.s44khin.simpleweather.common.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.s44khin.simpleweather.core.di.AppViewModelFactory

val LocalViewModelFactory = staticCompositionLocalOf<AppViewModelFactory> { error("AppViewModelFactory not provided") }

@Composable
inline fun <reified T : ViewModel> daggerViewModel() = viewModel<T>(factory = LocalViewModelFactory.current)