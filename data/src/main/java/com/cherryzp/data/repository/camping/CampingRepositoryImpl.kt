package com.cherryzp.data.repository.camping

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.cherryzp.data.remote.dataSource.CampingPagingDataSource
import com.cherryzp.data.remote.dataSource.CampingRemoteDataSource
import com.cherryzp.domain.model.Camping
import com.cherryzp.domain.repository.camping.CampingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CampingRepositoryImpl @Inject constructor(
    private val campingRemoteDataSource: CampingRemoteDataSource,
    private val campingPagingDataSource: CampingPagingDataSource
): CampingRepository {
    override fun getCampingPagingList(
        numOfRows: Int
    ): Flow<PagingData<Camping>> {
        return Pager(
            config = PagingConfig(pageSize = numOfRows, enablePlaceholders = false),
            pagingSourceFactory = { campingPagingDataSource }
        ).flow
    }
}