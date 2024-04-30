package dev.s44khin.simpleweather.core.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.s44khin.simpleweather.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private companion object {
        const val BASE_URL = "https://api.openweathermap.org/data/"
    }

    @Provides
    fun provideHttpClientBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    if (BuildConfig.DEBUG) {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                }
            )
            .addInterceptor { chain ->
                var request = chain.request()
                val url = chain.request().url
                    .newBuilder()
                    .addQueryParameter("appid", API_KEY)
                    .build()

                request = request.newBuilder().url(url).build()
                chain.proceed(request)
            }
    }

    @Provides
    fun provideMoshiBuilder() = Moshi.Builder()

    @Provides
    fun provideRetrofit(
        httpClientBuilder: OkHttpClient.Builder,
        moshiBuilder: Moshi.Builder
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClientBuilder.build())
            .addConverterFactory(MoshiConverterFactory.create(moshiBuilder.build()))
            .build()
    }
}