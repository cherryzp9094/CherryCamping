package com.cherryzp.domain.usecase.camping

import androidx.paging.PagingData
import com.cherryzp.domain.dto.CampingDto
import com.cherryzp.domain.repository.camping.CampingRepository
import com.cherryzp.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

open class GetCampingListUseCase @Inject constructor(
    private val campingRepository: CampingRepository,
) : UseCase<Int, Flow<PagingData<CampingDto>>>() {

    override fun execute(parameter: Int): Flow<PagingData<CampingDto>> {
        return campingRepository.getCampingPagingList(parameter)
    }
}