package dev.s44khin.simpleweather.common.core.di

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.data.CommonRepositoryImpl
import dev.s44khin.simpleweather.common.data.local.CommonLocal
import dev.s44khin.simpleweather.common.data.local.SharedPrefSettings
import dev.s44khin.simpleweather.common.data.remote.CommonRemote
import dev.s44khin.simpleweather.common.domain.mappers.SearchLocationMapper
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val commonDataModule = module {
    factory { SharedPrefSettings(androidApplication()) }

    factoryOf(::CommonLocal)
    factoryOf(::CommonRemote)
    factoryOf(::SearchLocationMapper)

    single<CommonRepository> { CommonRepositoryImpl(get(), get()) }
}