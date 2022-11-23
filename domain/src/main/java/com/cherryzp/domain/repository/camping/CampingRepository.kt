package com.cherryzp.domain.repository.camping

import androidx.paging.PagingData
import com.cherryzp.domain.dto.CampingDto
import kotlinx.coroutines.flow.Flow

interface CampingRepository {

    suspend fun getCampingList(
        numOfRows: Int,
        pageNo: Int,
        mobileOs: String,
        mobileApp: String,
    ): List<CampingDto>?

    suspend fun getCampingPagingList(
        numOfRows: Int,
        mobileOs: String,
        mobileApp: String
    ): Flow<PagingData<CampingDto>>
}