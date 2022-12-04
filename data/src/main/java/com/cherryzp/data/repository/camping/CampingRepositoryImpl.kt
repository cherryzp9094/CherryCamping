package com.cherryzp.data.repository.camping

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.cherryzp.data.remote.CampingPagingDataSource
import com.cherryzp.data.remote.CampingRemoteDataSource
import com.cherryzp.domain.dto.CampingDto
import com.cherryzp.domain.repository.camping.CampingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CampingRepositoryImpl @Inject constructor(
    private val campingRemoteDataSource: CampingRemoteDataSource,
    private val campingPagingDataSource: CampingPagingDataSource
): CampingRepository {

    override suspend fun getCampingPagingList(
        numOfRows: Int
    ): Flow<PagingData<CampingDto>> {
        return Pager(
            config = PagingConfig(pageSize = numOfRows, enablePlaceholders = false),
            pagingSourceFactory = { campingPagingDataSource }
        ).flow
    }
}