package com.cherryzp.domain.repository.camping

import androidx.paging.PagingData
import com.cherryzp.domain.dto.CampingDto
import kotlinx.coroutines.flow.Flow

interface CampingRepository {

    suspend fun getCampingPagingList(
        numOfRows: Int
    ): Flow<PagingData<CampingDto>>
}