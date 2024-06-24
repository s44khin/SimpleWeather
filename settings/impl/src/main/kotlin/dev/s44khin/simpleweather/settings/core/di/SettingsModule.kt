package dev.s44khin.simpleweather.settings.core.di

import org.koin.dsl.module

val settingsModule = module {
    includes(
        settingsPresentationModule,
    )
}