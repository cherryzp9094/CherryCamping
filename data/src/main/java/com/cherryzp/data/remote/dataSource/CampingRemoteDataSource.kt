package com.cherryzp.data.remote.dataSource

import com.cherryzp.data.api.client.NetworkResponse
import com.cherryzp.data.remote.model.camping.CampingBaseListData
import com.cherryzp.data.remote.model.camping.CampingData
import com.cherryzp.data.remote.model.camping.CampingErrorResponse
import com.cherryzp.data.remote.model.camping.ResponseBase

interface CampingRemoteDataSource {

    /**
     * 캠핑 기본 리스트 불러오기
     */
    suspend fun getBasedList(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        mobileOs: String,
        mobileApp: String,
        type: String
    ): NetworkResponse<ResponseBase<CampingBaseListData<CampingData>>, CampingErrorResponse>

}