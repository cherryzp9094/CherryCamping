package com.cherryzp.data.repository.camping

import android.util.Log
import com.cherryzp.data.BuildConfig
import com.cherryzp.data.mapper.camping.mapperToCamping
import com.cherryzp.data.repository.camping.remote.CampingRemoteDataSource
import com.cherryzp.domain.model.Camping
import com.cherryzp.domain.repository.camping.CampingRepository
import javax.inject.Inject

class CampingRepositoryImpl @Inject constructor(private val campingRemoteDataSource: CampingRemoteDataSource): CampingRepository {
    override suspend fun getCampingList(
        numOfRows: Int,
        pageNo: Int,
        mobileOs: String,
        mobileApp: String,
    ): List<Camping>? {
        return campingRemoteDataSource.getBasedList(BuildConfig.GO_CAMPING_API_KEY, numOfRows, pageNo, mobileOs, mobileApp, "json").body()?.let {
            mapperToCamping(it.response.body.items.item)
        }
    }
}