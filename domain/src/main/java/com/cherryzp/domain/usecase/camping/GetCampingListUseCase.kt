package com.cherryzp.domain.usecase.camping

import androidx.paging.PagingData
import com.cherryzp.domain.model.Camping
import com.cherryzp.domain.repository.camping.CampingRepository
import com.cherryzp.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

open class GetCampingListUseCase @Inject constructor(
    private val campingRepository: CampingRepository,
) : UseCase<Int, Flow<PagingData<Camping>>>() {

    override fun execute(parameter: Int): Flow<PagingData<Camping>> {
        return campingRepository.getCampingPagingList(parameter)
    }
}