package dev.s44khin.simpleweather.common.core.di

import dev.s44khin.simpleweather.common.api.domain.CommonRepository
import dev.s44khin.simpleweather.common.api.domain.useCases.GetAlwaysShowLabelUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.GetColorUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.GetThemeUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.GetTransparentUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.GetUnitsUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.IsResetSettingsAvailableUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.ResetSettingsUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.SearchLocationUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.SetAlwaysShowLabelUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.SetColorUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.SetThemeUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.SetTransparentUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.SetUnitsUseCase
import dev.s44khin.simpleweather.common.data.CommonRepositoryImpl
import dev.s44khin.simpleweather.common.data.local.CommonLocal
import dev.s44khin.simpleweather.common.data.local.SharedPrefSettings
import dev.s44khin.simpleweather.common.data.remote.CommonRemote
import dev.s44khin.simpleweather.common.domain.mappers.SearchLocationMapper
import dev.s44khin.simpleweather.common.domain.model.ConfirmationDialogData
import dev.s44khin.simpleweather.common.domain.useCases.GetAlwaysShowLabelUseCaseImpl
import dev.s44khin.simpleweather.common.domain.useCases.GetColorUseCaseImpl
import dev.s44khin.simpleweather.common.domain.useCases.GetThemeUseCaseImpl
import dev.s44khin.simpleweather.common.domain.useCases.GetTransparentUseCaseImpl
import dev.s44khin.simpleweather.common.domain.useCases.GetUnitsUseCaseImpl
import dev.s44khin.simpleweather.common.domain.useCases.IsResetSettingsAvailableUseCaseImpl
import dev.s44khin.simpleweather.common.domain.useCases.ResetSettingsUseCaseImpl
import dev.s44khin.simpleweather.common.domain.useCases.SearchLocationUseCaseImpl
import dev.s44khin.simpleweather.common.domain.useCases.SetAlwaysShowLabelUseCaseImpl
import dev.s44khin.simpleweather.common.domain.useCases.SetColorUseCaseImpl
import dev.s44khin.simpleweather.common.domain.useCases.SetThemeUseCaseImpl
import dev.s44khin.simpleweather.common.domain.useCases.SetTransparentUseCaseImpl
import dev.s44khin.simpleweather.common.domain.useCases.SetUnitsUseCaseImpl
import dev.s44khin.simpleweather.common.presentation.confirmationDialog.ConfirmationDialogConverter
import dev.s44khin.simpleweather.common.presentation.confirmationDialog.ConfirmationDialogViewModel
import dev.s44khin.simpleweather.common.presentation.searchDialog.SearchDialogConverter
import dev.s44khin.simpleweather.common.presentation.searchDialog.SearchDialogViewModel
import dev.s44khin.simpleweather.utils.AutoClearable
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
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

    single<CommonRepository> { CommonRepositoryImpl(get(), get()) }

    factory<GetAlwaysShowLabelUseCase> { GetAlwaysShowLabelUseCaseImpl(get()) }
    factory<GetColorUseCase> { GetColorUseCaseImpl(get()) }
    factory<GetThemeUseCase> { GetThemeUseCaseImpl(get()) }
    factory<GetTransparentUseCase> { GetTransparentUseCaseImpl(get()) }
    factory<GetUnitsUseCase> { GetUnitsUseCaseImpl(get()) }
    factory<ResetSettingsUseCase> { ResetSettingsUseCaseImpl(get()) }
    factory<SearchLocationUseCase> { SearchLocationUseCaseImpl(get()) }
    factory<SetAlwaysShowLabelUseCase> { SetAlwaysShowLabelUseCaseImpl(get()) }
    factory<SetColorUseCase> { SetColorUseCaseImpl(get()) }
    factory<SetThemeUseCase> { SetThemeUseCaseImpl(get()) }
    factory<SetTransparentUseCase> { SetTransparentUseCaseImpl(get()) }
    factory<SetUnitsUseCase> { SetUnitsUseCaseImpl(get()) }
    factory<IsResetSettingsAvailableUseCase> { IsResetSettingsAvailableUseCaseImpl(get()) }
}
