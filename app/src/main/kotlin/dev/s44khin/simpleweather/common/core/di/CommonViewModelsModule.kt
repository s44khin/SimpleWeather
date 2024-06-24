package dev.s44khin.simpleweather.common.core.di

import dev.s44khin.simpleweather.common.presentation.confirmationDialog.ConfirmationDialogConverter
import dev.s44khin.simpleweather.common.presentation.confirmationDialog.ConfirmationDialogViewModel
import dev.s44khin.simpleweather.common.presentation.searchDialog.SearchDialogConverter
import dev.s44khin.simpleweather.common.presentation.searchDialog.SearchDialogViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val commonViewModelsModule = module {
    viewModelOf(::ConfirmationDialogViewModel)
    factoryOf(::ConfirmationDialogConverter)

    viewModelOf(::SearchDialogViewModel)
    factoryOf(::SearchDialogConverter)
}
