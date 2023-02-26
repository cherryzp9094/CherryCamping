package com.cherryzp.data.di

import com.cherryzp.data.api.GoCampingService
import com.cherryzp.data.remote.dataSource.CampingPagingDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PagingSourceModule {

    @Singleton
    @Provides
    fun provideCampingPagingDataSource(
        goCampingService: GoCampingService
    ): CampingPagingDataSource = CampingPagingDataSource(goCampingService)

}