package com.cherryzp.data.di

import com.cherryzp.data.api.GoCampingApi
import com.cherryzp.data.repository.camping.remote.CampingRemoteDataSource
import com.cherryzp.data.repository.camping.remote.CampingRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Provides
    fun provideCampingRemoteDataSource(campingApi: GoCampingApi): CampingRemoteDataSource {
        return CampingRemoteDataSourceImpl(campingApi)
    }

}