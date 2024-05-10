package dev.s44khin.simpleweather.common.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.s44khin.simpleweather.common.data.remote.CommonApi
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class CommonNetworkModule {

    @Provides
    fun provideCommonApi(retrofit: Retrofit): CommonApi = retrofit.create(CommonApi::class.java)
}