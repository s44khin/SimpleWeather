package dev.s44khin.simpleweather.today.core.di

import dev.s44khin.simpleweather.today.presentation.forecast.TodayForecastViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

internal val todayPresentationModule = module {
    viewModelOf(::TodayForecastViewModel)
}