package com.cherryzp.data.model.camping

data class BodyResponse(
    val items: List<CampingResponse>,
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int
)
