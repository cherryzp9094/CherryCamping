package com.cherryzp.domain.di

import com.cherryzp.domain.repository.camping.CampingRepository
import com.cherryzp.domain.usecase.camping.GetCampingListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    fun provideGetCampingListUseCase(campingRepository: CampingRepository): GetCampingListUseCase {
        return GetCampingListUseCase(campingRepository)
    }

}