package com.cherryzp.domain.repository.camping

import com.cherryzp.domain.model.Camping
import io.reactivex.Flowable
import retrofit2.Callback
import retrofit2.Response

interface CampingRepository {

    suspend fun getCampingList(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        mobileOs: String,
        mobileApp: String,
        type: String
    ): List<Camping>?

}