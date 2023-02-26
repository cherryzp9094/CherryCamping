package com.cherryzp.data.di

import com.cherryzp.data.remote.dataSource.CampingPagingDataSource
import com.cherryzp.data.remote.dataSource.CampingRemoteDataSource
import com.cherryzp.data.repository.camping.CampingRepositoryImpl
import com.cherryzp.domain.repository.camping.CampingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideCampingRepository(
        campingRemoteDataSource: CampingRemoteDataSource,
        campingPagingDataSource: CampingPagingDataSource
    ): CampingRepository {
        return CampingRepositoryImpl(campingRemoteDataSource, campingPagingDataSource)
    }

}