package dev.s44khin.simpleweather.di

import dev.s44khin.simpleweather.common.core.di.commonModule
import dev.s44khin.simpleweather.core.network.networkModule
import dev.s44khin.simpleweather.navigation.di.navigationModule
import dev.s44khin.simpleweather.settings.core.di.settingsModule
import dev.s44khin.simpleweather.today.core.di.todayModule
import org.koin.dsl.module

internal val appModule = module {
    includes(
        commonModule,
        mainModule,
        navigationModule,
        networkModule,
        settingsModule,
        todayModule,
    )
}
