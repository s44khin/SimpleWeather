package dev.s44khin.simpleweather.today.core.di

import org.koin.dsl.module

val todayModule = module {
    includes(
        todayDataModule,
        todayDomainModule,
        todayPresentationModule,
    )
}