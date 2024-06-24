package dev.s44khin.simpleweather.settings.core.di

import dev.s44khin.simpleweather.settings.presentation.SettingsListConverter
import dev.s44khin.simpleweather.settings.presentation.SettingsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val settingsModule = module {
    viewModelOf(::SettingsListViewModel)
    factoryOf(::SettingsListConverter)
}