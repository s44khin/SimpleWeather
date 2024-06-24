package dev.s44khin.simpleweather.core.di

import dev.s44khin.simpleweather.common.core.di.commonModule
import dev.s44khin.simpleweather.navigation.di.navigationModule
import dev.s44khin.simpleweather.settings.core.di.settingsModule
import dev.s44khin.simpleweather.today.core.di.todayModule
import org.koin.dsl.module

val appModule = module {
    includes(
        navigationModule,
        networkModule,
        commonModule,
        coreModule,
        todayModule,
        settingsModule
    )
}