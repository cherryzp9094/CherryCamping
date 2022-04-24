package com.cherryzp.data.repository.camping

import com.cherryzp.data.mapper.camping.mapperToCamping
import com.cherryzp.data.repository.camping.remote.CampingRemoteDataSource
import com.cherryzp.domain.model.Camping
import com.cherryzp.domain.repository.camping.CampingRepository
import javax.inject.Inject

class CampingRepositoryImpl @Inject constructor(private val campingRemoteDataSource: CampingRemoteDataSource): CampingRepository {
    override suspend fun getCampingList(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        mobileOs: String,
        mobileApp: String,
        type: String
    ): List<Camping>? {
        return campingRemoteDataSource.getBasedList(serviceKey, numOfRows, pageNo, mobileOs, mobileApp, type).body()?.let {
            mapperToCamping(it.body.items)
        }
    }
}