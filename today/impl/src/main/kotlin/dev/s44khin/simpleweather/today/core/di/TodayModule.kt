package dev.s44khin.simpleweather.today.core.di

import dev.s44khin.simpleweather.today.data.remote.TodayRemote
import dev.s44khin.simpleweather.today.domain.TodayRepository
import dev.s44khin.simpleweather.today.domain.mappers.TodayWeatherMapper
import dev.s44khin.simpleweather.today.domain.useCases.GetTodayWeatherUseCase
import dev.s44khin.simpleweather.today.presentation.forecast.TodayForecastConverter
import dev.s44khin.simpleweather.today.presentation.forecast.TodayForecastViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val todayModule = module {
    viewModelOf(::TodayForecastViewModel)
    factoryOf(::TodayForecastConverter)

    factoryOf(::TodayWeatherMapper)
    factoryOf(::TodayRemote)
    factoryOf(::TodayRepository)

    factoryOf(::GetTodayWeatherUseCase)
}