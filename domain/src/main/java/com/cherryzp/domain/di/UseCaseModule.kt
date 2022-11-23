package com.cherryzp.domain.di

import com.cherryzp.domain.repository.camping.CampingRepository
import com.cherryzp.domain.usecase.camping.GetCampingListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    fun provideGetCampingListUseCase(campingRepository: CampingRepository, @IoDispatcher ioDispatcher: CoroutineDispatcher): GetCampingListUseCase {
        return GetCampingListUseCase(campingRepository, ioDispatcher)
    }

}