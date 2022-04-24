package com.cherryzp.data.repository.camping.remote

import com.cherryzp.data.api.GoCampingApi
import com.cherryzp.data.model.camping.BasedListResponse
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
    ): Response<BasedListResponse> {
        return campingApi.getBasedList(serviceKey, numOfRows, pageNo, mobileOs, mobileApp, type)
    }
}