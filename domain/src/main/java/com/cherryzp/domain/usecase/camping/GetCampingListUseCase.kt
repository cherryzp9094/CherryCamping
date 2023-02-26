package com.cherryzp.domain.usecase.camping

import androidx.paging.PagingData
import com.cherryzp.domain.di.IoDispatcher
import com.cherryzp.domain.model.Camping
import com.cherryzp.domain.repository.camping.CampingRepository
import com.cherryzp.domain.usecase.CoroutineUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

open class GetCampingListUseCase @Inject constructor(
    private val campingRepository: CampingRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : CoroutineUseCase<Int, Flow<PagingData<Camping>>>(
    dispatcher
) {

    override suspend fun execute(parameter: Int): Flow<PagingData<Camping>> =
        campingRepository.getCampingPagingList(parameter)

}