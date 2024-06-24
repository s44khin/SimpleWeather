package dev.s44khin.simpleweather.common.core.di

import dev.s44khin.simpleweather.common.api.domain.model.ConfirmationDialogData
import dev.s44khin.simpleweather.utils.AutoClearable
import org.koin.dsl.module

internal val commonDataSourceModule = module {
    single<AutoClearable<ConfirmationDialogData>> {
        object : AutoClearable<ConfirmationDialogData>() {}
    }
}
