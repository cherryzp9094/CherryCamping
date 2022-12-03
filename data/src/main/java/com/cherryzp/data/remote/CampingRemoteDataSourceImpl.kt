package com.cherryzp.data.remote

import com.cherryzp.data.api.GoCampingService
import com.cherryzp.data.api.client.NetworkResponse
import com.cherryzp.data.model.camping.CampingBaseListEntity
import com.cherryzp.data.model.camping.CampingEntity
import com.cherryzp.data.model.camping.ResponseBase
import com.cherryzp.data.model.camping.CampingErrorResponse
import javax.inject.Inject

class CampingRemoteDataSourceImpl @Inject constructor(private val campingApi: GoCampingService):
    CampingRemoteDataSource {
    override suspend fun getBasedList(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        mobileOs: String,
        mobileApp: String,
        type: String
    ): NetworkResponse<ResponseBase<CampingBaseListEntity<CampingEntity>>, CampingErrorResponse> {
        return campingApi.getBasedList(serviceKey, numOfRows, pageNo, mobileOs, mobileApp, type)
    }
}