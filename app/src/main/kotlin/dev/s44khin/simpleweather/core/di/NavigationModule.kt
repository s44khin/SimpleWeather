package dev.s44khin.simpleweather.core.di

import dev.s44khin.simpleweather.core.navigation.ScreenRouter
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val navigationModule = module {
    singleOf(::ScreenRouter)
}
