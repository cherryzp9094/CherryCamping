package com.cherryzp.data.repository.camping.remote

import com.cherryzp.data.api.client.NetworkResponse
import com.cherryzp.data.model.camping.BasedListResponse
import com.cherryzp.data.model.camping.CampingErrorResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response

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
    ): NetworkResponse<BasedListResponse, CampingErrorResponse>

}