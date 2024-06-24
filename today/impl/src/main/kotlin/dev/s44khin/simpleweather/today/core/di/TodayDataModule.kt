package dev.s44khin.simpleweather.today.core.di

import dev.s44khin.simpleweather.today.data.remote.TodayRemote
import dev.s44khin.simpleweather.today.domain.TodayRepository
import dev.s44khin.simpleweather.today.domain.mappers.TodayWeatherMapper
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val todayDataModule = module {
    factoryOf(::TodayRemote)
    factoryOf(::TodayRepository)
    factoryOf(::TodayWeatherMapper)
}
