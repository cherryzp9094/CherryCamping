package com.cherryzp.data.api

import com.cherryzp.data.api.client.NetworkResponse
import com.cherryzp.data.remote.model.camping.CampingBaseListData
import com.cherryzp.data.remote.model.camping.CampingData
import com.cherryzp.data.remote.model.camping.CampingErrorResponse
import com.cherryzp.data.remote.model.camping.ResponseBase
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
    ): NetworkResponse<ResponseBase<CampingBaseListData<CampingData>>, CampingErrorResponse>

    companion object {
        const val SERVICE_KEY = "ServiceKey"
        const val NUM_OF_ROWS = "numOfRows"
        const val PAGE_NO = "pageNo"
        const val MOBILE_OS = "MobileOS"
        const val MOBILE_APP = "MobileApp"
        const val TYPE = "_type"
    }
}