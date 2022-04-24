package com.cherryzp.domain.usecase.camping

import com.cherryzp.domain.model.Camping
import com.cherryzp.domain.repository.camping.CampingRepository
import javax.inject.Inject

class GetCampingListUseCase @Inject constructor(private val campingRepository: CampingRepository) {
    suspend fun excute(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        mobileOs: String,
        mobileApp: String,
        type: String
    ): List<Camping>? = campingRepository.getCampingList(serviceKey, numOfRows, pageNo, mobileOs, mobileApp, type)
}