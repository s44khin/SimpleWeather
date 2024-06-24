package dev.s44khin.simpleweather.di

import dev.s44khin.simpleweather.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

internal val mainPresentationModule = module {
    viewModelOf(::MainViewModel)
}
