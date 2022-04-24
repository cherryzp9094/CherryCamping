package com.cherryzp.data.di

import com.cherryzp.data.repository.camping.CampingRepositoryImpl
import com.cherryzp.data.repository.camping.remote.CampingRemoteDataSource
import com.cherryzp.domain.repository.camping.CampingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    fun provideCampingRepository(campingRemoteDataSource: CampingRemoteDataSource): CampingRepository {
        return CampingRepositoryImpl(campingRemoteDataSource)
    }

}