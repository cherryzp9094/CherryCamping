package com.cherryzp.domain.repository.camping

import androidx.paging.PagingData
import com.cherryzp.domain.model.Camping
import kotlinx.coroutines.flow.Flow

interface CampingRepository {
    fun getCampingPagingList(
        numOfRows: Int
    ): Flow<PagingData<Camping>>
}