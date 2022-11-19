package com.cherryzp.domain.usecase.camping

import com.cherryzp.domain.model.Camping
import com.cherryzp.domain.repository.camping.CampingRepository
import javax.inject.Inject

class GetCampingListUseCase @Inject constructor(private val campingRepository: CampingRepository) {

    suspend fun excute(
        numOfRows: Int,
        pageNo: Int,
        mobileOs: String,
        mobileApp: String,
    ): List<Camping>? = campingRepository.getCampingList(numOfRows, pageNo, mobileOs, mobileApp)
}