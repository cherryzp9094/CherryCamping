package com.cherryzp.data.mapper.camping

import com.cherryzp.data.model.camping.CampingResponse
import com.cherryzp.domain.model.Camping

fun mapperToCamping(campings: List<CampingResponse>): List<Camping> {
    return campings.toList().map {
        Camping(
            it.addr1
        )
    }
}