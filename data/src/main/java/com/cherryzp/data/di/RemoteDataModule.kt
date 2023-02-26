package com.cherryzp.data.di

import com.cherryzp.data.api.GoCampingService
import com.cherryzp.data.remote.dataSource.CampingRemoteDataSource
import com.cherryzp.data.remote.dataSource.CampingRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideCampingRemoteDataSource(campingService: GoCampingService): CampingRemoteDataSource {
        return CampingRemoteDataSourceImpl(campingService)
    }
}