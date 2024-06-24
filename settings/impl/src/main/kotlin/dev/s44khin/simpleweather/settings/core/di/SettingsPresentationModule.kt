package dev.s44khin.simpleweather.settings.core.di

import dev.s44khin.simpleweather.settings.presentation.SettingsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

internal val settingsPresentationModule = module {
    viewModelOf(::SettingsListViewModel)
}
