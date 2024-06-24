package dev.s44khin.simpleweather.today.core.di

import dev.s44khin.simpleweather.today.domain.useCases.GetTodayWeatherUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val todayDomainModule = module {
    factoryOf(::GetTodayWeatherUseCase)
}
