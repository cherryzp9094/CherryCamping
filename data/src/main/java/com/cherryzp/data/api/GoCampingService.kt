package com.cherryzp.data.api

import com.cherryzp.data.api.client.NetworkResponse
import com.cherryzp.data.model.camping.CampingBaseListEntity
import com.cherryzp.data.model.camping.CampingEntity
import com.cherryzp.data.model.camping.ResponseBase
import com.cherryzp.data.model.camping.CampingErrorResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GoCampingService {
    @GET("basedList")
    suspend fun getBasedList(
        @Query("ServiceKey", encoded = true) serviceKey: String,
        @Query("numOfRows") numOfRows: Int? = 20,
        @Query("pageNo") pageNo: Int,
        @Query("MobileOS") mobileOs: String? = "AND",
        @Query("MobileApp", encoded = true) mobileApp: String? = "AppTest",
        @Query("_type") type: String? = "json"
    ): NetworkResponse<ResponseBase<CampingBaseListEntity<CampingEntity>>, CampingErrorResponse>
}