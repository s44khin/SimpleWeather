package dev.s44khin.simpleweather.core

import android.app.Application
import dev.s44khin.simpleweather.common.core.di.commonModule
import dev.s44khin.simpleweather.core.di.coreModule
import dev.s44khin.simpleweather.core.di.navigationModule
import dev.s44khin.simpleweather.core.di.networkModule
import dev.s44khin.simpleweather.settings.core.di.settingsModule
import dev.s44khin.simpleweather.today.core.di.todayModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)

            modules(
                navigationModule,
                networkModule,
                commonModule,
                coreModule,
                todayModule,
                settingsModule
            )
        }
    }
}
