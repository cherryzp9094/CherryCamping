package com.cherryzp.data.api

import com.cherryzp.data.api.client.NetworkResponse
import com.cherryzp.data.entitiy.camping.CampingBaseListEntity
import com.cherryzp.data.entitiy.camping.CampingEntity
import com.cherryzp.data.entitiy.camping.ResponseBase
import com.cherryzp.data.entitiy.camping.CampingErrorResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GoCampingService {
    @GET("basedList")
    suspend fun getBasedList(
        @Query(SERVICE_KEY, encoded = true) serviceKey: String,
        @Query(NUM_OF_ROWS) numOfRows: Int? = 20,
        @Query(PAGE_NO) pageNo: Int,
        @Query(MOBILE_OS) mobileOs: String = "AND",
        @Query(MOBILE_APP, encoded = true) mobileApp: String = "AppTest",
        @Query(TYPE) type: String = "json"
    ): NetworkResponse<ResponseBase<CampingBaseListEntity<CampingEntity>>, CampingErrorResponse>

    companion object {
        const val SERVICE_KEY = "ServiceKey"
        const val NUM_OF_ROWS = "numOfRows"
        const val PAGE_NO = "pageNo"
        const val MOBILE_OS = "MobileOS"
        const val MOBILE_APP = "MobileApp"
        const val TYPE = "_type"
    }
}