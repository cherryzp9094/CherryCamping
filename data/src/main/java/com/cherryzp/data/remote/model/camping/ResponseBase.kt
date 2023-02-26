package com.cherryzp.data.remote.model.camping

data class ResponseBase<T>(
    val response: ResponseResult<T>
) {
    data class ResponseResult<T>(
        val header: HeaderResponse?,
        val body: T?
    )
}
