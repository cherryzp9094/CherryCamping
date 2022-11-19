package com.cherryzp.data.di

import com.cherryzp.data.api.GoCampingService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provideGoCampingApi(
        retrofit: Retrofit
    ): GoCampingService = retrofit.newBuilder().build().create(GoCampingService::class.java)

}