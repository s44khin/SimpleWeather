package dev.s44khin.simpleweather.di

import org.koin.dsl.module

val mainModule = module {
    includes(
        mainPresentationModule,
    )
}
