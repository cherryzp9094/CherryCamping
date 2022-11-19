package com.cherryzp.data.di

import com.cherryzp.data.repository.camping.CampingRepositoryImpl
import com.cherryzp.data.remote.CampingPagingDataSource
import com.cherryzp.data.remote.CampingRemoteDataSource
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