package com.cherryzp.cherrycamping.di

import com.cherryzp.cherrycamping.utils.loading.LoadingState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideLoading(): LoadingState = LoadingState()
}