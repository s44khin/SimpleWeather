package dev.s44khin.simpleweather.common.core.di

import dev.s44khin.simpleweather.common.presentation.confirmationDialog.ConfirmationDialogViewModel
import dev.s44khin.simpleweather.common.presentation.searchDialog.SearchDialogViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

internal val commonPresentationModule = module {
    viewModelOf(::ConfirmationDialogViewModel)
    viewModelOf(::SearchDialogViewModel)
}
