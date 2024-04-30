package dev.s44khin.simpleweather.today.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.s44khin.simpleweather.today.data.TodayApi
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class TodayNetworkModule {

    @Provides
    fun provideTodayApi(retrofit: Retrofit): TodayApi = retrofit.create(TodayApi::class.java)
}