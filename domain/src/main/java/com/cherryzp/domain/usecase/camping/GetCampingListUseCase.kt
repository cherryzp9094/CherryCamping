package com.cherryzp.domain.usecase.camping

import androidx.paging.PagingData
import com.cherryzp.domain.di.IoDispatcher
import com.cherryzp.domain.dto.CampingDto
import com.cherryzp.domain.repository.camping.CampingRepository
import com.cherryzp.domain.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

open class GetCampingListUseCase @Inject constructor(
    private val campingRepository: CampingRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
    ): UseCase<GetCampingRequestParameter, Flow<PagingData<CampingDto>>>(dispatcher) {

    override suspend fun execute(parameter: GetCampingRequestParameter): Flow<PagingData<CampingDto>> {
        val (numOfRows, mobileOs, mobileApp) = parameter
        return campingRepository.getCampingPagingList(numOfRows, mobileOs, mobileApp)
    }
}

data class GetCampingRequestParameter(
    val numOfRows: Int,
    val mobileOs: String,
    val mobileApp: String
)