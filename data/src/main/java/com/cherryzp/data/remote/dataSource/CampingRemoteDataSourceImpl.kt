package com.cherryzp.data.remote.dataSource

import com.cherryzp.data.api.GoCampingService
import com.cherryzp.data.api.client.NetworkResponse
import com.cherryzp.data.remote.model.camping.CampingBaseListData
import com.cherryzp.data.remote.model.camping.CampingData
import com.cherryzp.data.remote.model.camping.CampingErrorResponse
import com.cherryzp.data.remote.model.camping.ResponseBase
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
    ): NetworkResponse<ResponseBase<CampingBaseListData<CampingData>>, CampingErrorResponse> {
        return campingApi.getBasedList(serviceKey, numOfRows, pageNo, mobileOs, mobileApp, type)
    }
}