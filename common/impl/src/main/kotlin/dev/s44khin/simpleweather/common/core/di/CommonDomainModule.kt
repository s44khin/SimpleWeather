package dev.s44khin.simpleweather.common.core.di

import dev.s44khin.simpleweather.common.api.domain.useCases.GetAlwaysShowLabelUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.GetColorUseCase
import dev.s44khin.simpleweather.common.api.domain.useCases.GetForecastUseCase
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
import dev.s44khin.simpleweather.common.domain.useCases.GetAlwaysShowLabelUseCaseImpl
import dev.s44khin.simpleweather.common.domain.useCases.GetColorUseCaseImpl
import dev.s44khin.simpleweather.common.domain.useCases.GetForecastUseCaseImpl
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
import org.koin.dsl.module

internal val commonDomainModule = module {
    factory<GetAlwaysShowLabelUseCase> { GetAlwaysShowLabelUseCaseImpl(get()) }
    factory<GetColorUseCase> { GetColorUseCaseImpl(get()) }
    factory<GetThemeUseCase> { GetThemeUseCaseImpl(get()) }
    factory<GetTransparentUseCase> { GetTransparentUseCaseImpl(get()) }
    factory<GetUnitsUseCase> { GetUnitsUseCaseImpl(get()) }
    factory<IsResetSettingsAvailableUseCase> { IsResetSettingsAvailableUseCaseImpl(get()) }
    factory<ResetSettingsUseCase> { ResetSettingsUseCaseImpl(get()) }
    factory<SearchLocationUseCase> { SearchLocationUseCaseImpl(get()) }
    factory<SetAlwaysShowLabelUseCase> { SetAlwaysShowLabelUseCaseImpl(get()) }
    factory<SetColorUseCase> { SetColorUseCaseImpl(get()) }
    factory<SetThemeUseCase> { SetThemeUseCaseImpl(get()) }
    factory<SetTransparentUseCase> { SetTransparentUseCaseImpl(get()) }
    factory<SetUnitsUseCase> { SetUnitsUseCaseImpl(get()) }
    factory<GetForecastUseCase> { GetForecastUseCaseImpl(get()) }
}
