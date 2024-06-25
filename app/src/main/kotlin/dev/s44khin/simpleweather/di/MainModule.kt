package dev.s44khin.simpleweather.di

import org.koin.dsl.module

internal val mainModule = module {
    includes(
        mainPresentationModule,
    )
}
