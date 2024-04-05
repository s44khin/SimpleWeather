package dev.s44khin.simpleweather.core.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dev.s44khin.simpleweather.core.di.module.ViewModelsModule
import dev.s44khin.simpleweather.core.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ViewModelsModule::class, NavigationModule::class]
)
interface AppComponent {

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun addContext(context: Context): Builder

        fun build(): AppComponent
    }
}