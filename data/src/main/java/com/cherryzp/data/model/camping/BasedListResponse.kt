package com.cherryzp.data.model.camping

data class BasedListResponse(
    val response: BasedListBodyResponse
) {
    data class BasedListBodyResponse(
        val header: HeaderResponse,
        val body: BodyResponse
    )
}
