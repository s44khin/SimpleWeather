package dev.s44khin.simpleweather.navigation.di

import dev.s44khin.simpleweather.navigation.ScreenRouterImpl
import dev.s44khin.simpleweather.navigation.api.ScreenRouter
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val navigationModule = module {
    singleOf<ScreenRouter>(::ScreenRouterImpl)
}
