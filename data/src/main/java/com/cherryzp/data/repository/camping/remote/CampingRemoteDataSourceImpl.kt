package com.cherryzp.data.repository.camping.remote

import com.cherryzp.data.api.GoCampingApi
import com.cherryzp.data.api.client.NetworkResponse
import com.cherryzp.data.model.camping.BasedListResponse
import com.cherryzp.data.model.camping.CampingErrorResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class CampingRemoteDataSourceImpl @Inject constructor(private val campingApi: GoCampingApi): CampingRemoteDataSource {
    override suspend fun getBasedList(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        mobileOs: String,
        mobileApp: String,
        type: String
    ): NetworkResponse<BasedListResponse, CampingErrorResponse> {
        return campingApi.getBasedList(serviceKey, numOfRows, pageNo, mobileOs, mobileApp, type)
    }
}