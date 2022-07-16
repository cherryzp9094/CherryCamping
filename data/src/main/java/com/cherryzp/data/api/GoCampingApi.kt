package com.cherryzp.data.api

import com.cherryzp.data.api.client.NetworkResponse
import com.cherryzp.data.api.client.provideRetrofit
import com.cherryzp.data.model.camping.BasedListResponse
import com.cherryzp.data.model.camping.CampingErrorResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GoCampingApi {

    @GET("basedList")
    suspend fun getBasedList(
        @Query("ServiceKey", encoded = true) serviceKey: String,
        @Query("numOfRows") numOfRows: Int? = 20,
        @Query("pageNo") pageNo: Int,
        @Query("MobileOS") mobileOs: String? = "AND",
        @Query("MobileApp", encoded = true) mobileApp: String? = "AppTest",
        @Query("_type") type: String? = "json"
    ): NetworkResponse<BasedListResponse, CampingErrorResponse>

    companion object {
        fun create(): GoCampingApi = provideRetrofit().create(GoCampingApi::class.java)
    }

}