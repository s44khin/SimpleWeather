package dev.s44khin.simpleweather.common.core.di

import dev.s44khin.simpleweather.common.clearable.AutoClearable
import dev.s44khin.simpleweather.common.data.CommonRepository
import dev.s44khin.simpleweather.common.data.local.CommonLocal
import dev.s44khin.simpleweather.common.data.local.SharedPrefSettings
import dev.s44khin.simpleweather.common.data.remote.CommonRemote
import dev.s44khin.simpleweather.common.domain.mappers.SearchLocationMapper
import dev.s44khin.simpleweather.common.domain.model.ConfirmationDialogData
import dev.s44khin.simpleweather.common.domain.useCases.GetAlwaysShowLabelUseCase
import dev.s44khin.simpleweather.common.domain.useCases.GetColorUseCase
import dev.s44khin.simpleweather.common.domain.useCases.GetThemeUseCase
import dev.s44khin.simpleweather.common.domain.useCases.GetTransparentUseCase
import dev.s44khin.simpleweather.common.domain.useCases.GetUnitsUseCase
import dev.s44khin.simpleweather.common.domain.useCases.ResetSettingsUseCase
import dev.s44khin.simpleweather.common.domain.useCases.SearchLocationUseCase
import dev.s44khin.simpleweather.common.domain.useCases.SetAlwaysShowLabelUseCase
import dev.s44khin.simpleweather.common.domain.useCases.SetColorUseCase
import dev.s44khin.simpleweather.common.domain.useCases.SetThemeUseCase
import dev.s44khin.simpleweather.common.domain.useCases.SetTransparentUseCase
import dev.s44khin.simpleweather.common.domain.useCases.SetUnitsUseCase
import dev.s44khin.simpleweather.common.presentation.confirmationDialog.ConfirmationDialogConverter
import dev.s44khin.simpleweather.common.presentation.confirmationDialog.ConfirmationDialogViewModel
import dev.s44khin.simpleweather.common.presentation.searchDialog.SearchDialogConverter
import dev.s44khin.simpleweather.common.presentation.searchDialog.SearchDialogViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val commonModule = module {
    viewModelOf(::ConfirmationDialogViewModel)
    factoryOf(::ConfirmationDialogConverter)

    viewModelOf(::SearchDialogViewModel)
    factoryOf(::SearchDialogConverter)

    single<AutoClearable<ConfirmationDialogData>> {
        object : AutoClearable<ConfirmationDialogData>() {}
    }

    factory { SharedPrefSettings(androidApplication()) }
    factoryOf(::CommonLocal)

    factoryOf(::SearchLocationMapper)
    factoryOf(::CommonRemote)

    singleOf(::CommonRepository)

    factoryOf(::GetAlwaysShowLabelUseCase)
    factoryOf(::GetColorUseCase)
    factoryOf(::GetThemeUseCase)
    factoryOf(::GetTransparentUseCase)
    factoryOf(::GetUnitsUseCase)
    factoryOf(::ResetSettingsUseCase)
    factoryOf(::SearchLocationUseCase)
    factoryOf(::SetAlwaysShowLabelUseCase)
    factoryOf(::SetColorUseCase)
    factoryOf(::SetThemeUseCase)
    factoryOf(::SetTransparentUseCase)
    factoryOf(::SetUnitsUseCase)
}
