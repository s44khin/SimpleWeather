package dev.s44khin.simpleweather.di

import dev.s44khin.simpleweather.main.MainConverter
import dev.s44khin.simpleweather.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val coreModule = module {
    viewModelOf(::MainViewModel)
    factoryOf(::MainConverter)
}
