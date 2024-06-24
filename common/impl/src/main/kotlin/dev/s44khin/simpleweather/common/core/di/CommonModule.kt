package dev.s44khin.simpleweather.common.core.di

import org.koin.dsl.module

val commonModule = module {
    includes(
        commonDataModule,
        commonDataSourceModule,
        commonDomainModule,
        commonPresentationModule,
    )
}
