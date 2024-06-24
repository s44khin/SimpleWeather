package dev.s44khin.simpleweather.core.network

import org.koin.dsl.module

val networkModule = module {
    single { createHttpClient() }
}
