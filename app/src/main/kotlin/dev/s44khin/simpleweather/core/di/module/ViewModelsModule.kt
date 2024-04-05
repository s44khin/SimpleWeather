package dev.s44khin.simpleweather.core.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.s44khin.simpleweather.core.di.ViewModelKey
import dev.s44khin.simpleweather.core.main.MainViewModel

@Module
interface ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}
