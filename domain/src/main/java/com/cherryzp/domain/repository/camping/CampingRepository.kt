package com.cherryzp.domain.repository.camping

import androidx.paging.PagingData
import com.cherryzp.domain.model.Camping
import kotlinx.coroutines.flow.Flow

interface CampingRepository {

    suspend fun getCampingList(
        numOfRows: Int,
        pageNo: Int,
        mobileOs: String,
        mobileApp: String,
    ): List<Camping>?

    suspend fun getCampingPagingList(): Flow<PagingData<Camping>>
}