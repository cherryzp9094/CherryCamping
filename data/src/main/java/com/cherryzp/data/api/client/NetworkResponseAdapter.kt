package com.cherryzp.data.api.client

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Converter
import java.lang.reflect.Type

/**
 *  `Type` 주석을 보면
 *  `common superinterface for all type in the Java'라고 나와 있다.
 *  그냥 모든 타입을 포함할 수 있다고 보면 되겠다.
 *
 * CallAdapter 주석을 보면
 * public interface CallAdapter<R, T>에서
 * adapt a Call with response type R into the type of T라고 나와있다.
 * 그러니까 R을 T로 바꾼다라고 보면 된다.
 * 지금 이렇게 GoCampingResponse~들을 만드는 이유가 요놈(GoCampingResponseAdapter)을 suspend fun에서 써먹기 위함이다.
 */
class NetworkResponseAdapter<S : Any, E : Any>(
    private val successType: Type,
    private val errorBodyConverter: Converter<ResponseBody, E>
) : CallAdapter<S, Call<NetworkResponse<S, E>>> {

    override fun responseType(): Type = successType

    override fun adapt(call: Call<S>): Call<NetworkResponse<S, E>> =
        NetworkResponseCall(call, errorBodyConverter)
}