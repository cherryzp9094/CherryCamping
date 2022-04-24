package com.cherryzp.data.api

import com.cherryzp.data.api.client.provideRetrofit
import com.cherryzp.data.model.camping.BasedListResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GoCampingApi {

    @GET
    suspend fun getBasedList(
        @Query("ServiceKey") serviceKey: String,
        @Query("numOfRows") numOfRows: Int,
        @Query("pageNo") pageNo: Int,
        @Query("MobileOS") mobileOs: String,
        @Query("MobileApp") mobileApp: String,
        @Query("_type") type: String
    ): Response<BasedListResponse>

    companion object {
        fun create(): GoCampingApi = provideRetrofit().create(GoCampingApi::class.java)
    }

}