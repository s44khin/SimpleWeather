package dev.s44khin.simpleweather.common.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dev.s44khin.simpleweather.common.clearable.AutoClearable
import dev.s44khin.simpleweather.common.domain.model.ConfirmationDialogData

@Module
@InstallIn(ActivityRetainedComponent::class)
class CommonModule {

    @Provides
    @ActivityRetainedScoped
    fun provideConfirmationDialogInMemory() = object : AutoClearable<ConfirmationDialogData>() {}
}