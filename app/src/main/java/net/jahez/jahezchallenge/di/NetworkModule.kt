package net.jahez.jahezchallenge.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.jahez.jahezchallenge.data.network.Api
import net.jahez.jahezchallenge.utils.IdManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient() : OkHttpClient{
        return OkHttpClient.Builder()
            .connectTimeout(59, TimeUnit.SECONDS)
            .readTimeout(59, TimeUnit.SECONDS)
            .writeTimeout(59, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideApi(okHttpClient: OkHttpClient): Api {
        return Retrofit.Builder()
            .baseUrl(IdManager.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(Api::class.java)
    }
}