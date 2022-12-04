package com.cherryzp.data.remote

import com.cherryzp.data.api.client.NetworkResponse
import com.cherryzp.data.entitiy.camping.CampingBaseListEntity
import com.cherryzp.data.entitiy.camping.CampingEntity
import com.cherryzp.data.entitiy.camping.ResponseBase
import com.cherryzp.data.entitiy.camping.CampingErrorResponse

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
    ): NetworkResponse<ResponseBase<CampingBaseListEntity<CampingEntity>>, CampingErrorResponse>

}