package com.cherryzp.data.repository.camping

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.cherryzp.data.BuildConfig
import com.cherryzp.data.api.GoCampingApi
import com.cherryzp.data.api.client.NetworkResponse
import com.cherryzp.data.mapper.camping.mapperToCamping
import com.cherryzp.data.repository.camping.remote.CampingPagingDataSource
import com.cherryzp.data.repository.camping.remote.CampingRemoteDataSource
import com.cherryzp.domain.model.Camping
import com.cherryzp.domain.repository.camping.CampingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CampingRepositoryImpl @Inject constructor(
    private val campingRemoteDataSource: CampingRemoteDataSource,
): CampingRepository {
    override suspend fun getCampingList(
        numOfRows: Int,
        pageNo: Int,
        mobileOs: String,
        mobileApp: String,
    ): List<Camping>? {
        return when(val response = campingRemoteDataSource.getBasedList(BuildConfig.GO_CAMPING_API_KEY, numOfRows, pageNo, mobileOs, mobileApp, "json")) {
            is NetworkResponse.Success -> {
                mapperToCamping(response.body.response.body.items.item)
            }
            else -> null
        }
    }

    override suspend fun getCampingPagingList(): Flow<PagingData<Camping>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { CampingPagingDataSource(GoCampingApi.create()) }
        ).flow
    }
}