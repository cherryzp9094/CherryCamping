package com.cherryzp.data.model.camping

data class CampingErrorResponse(
    val response: HeaderResponse
) {
    data class HeaderResponse(
        val header: ErrorResponse
    ) {
        data class ErrorResponse(
            val responseTime : String?,
            val resultCode : Int?,
            val resultMsg : String?
        )
    }
}
