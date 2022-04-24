package com.cherryzp.data.di

import com.cherryzp.data.api.GoCampingApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideGoCampingApi(): GoCampingApi = GoCampingApi.create()

}