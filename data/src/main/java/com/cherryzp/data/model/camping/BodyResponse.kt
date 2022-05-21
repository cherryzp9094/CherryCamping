package com.cherryzp.data.model.camping

data class BodyResponse(
    val items: Items,
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int
) {
    data class Items(
        val item: List<CampingResponse>
    )
}
