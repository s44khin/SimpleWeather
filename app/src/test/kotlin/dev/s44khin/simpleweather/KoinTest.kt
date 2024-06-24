package dev.s44khin.simpleweather

import dev.s44khin.simpleweather.di.appModule
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import org.junit.Test
import org.koin.android.test.verify.verify
import org.koin.core.annotation.KoinExperimentalAPI

class KoinTest {

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkKoinModule() {

        appModule.verify(
            extraTypes = listOf(HttpClientEngine::class, HttpClientConfig::class)
        )
    }
}
