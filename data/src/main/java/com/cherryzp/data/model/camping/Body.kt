package com.cherryzp.data.model.camping

data class Body(
    val items: List<Camping>,
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int
)
