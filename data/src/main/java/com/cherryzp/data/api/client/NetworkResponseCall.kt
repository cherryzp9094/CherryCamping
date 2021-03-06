package com.cherryzp.data.api.client

import okhttp3.Request
import okhttp3.ResponseBody
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException

// generic S는 response data class type이 되고
// E는 error type이 된다.
// NetworkResponseCall, 이 클래스는 Call의 Wrapper Class임을 염두해두자
internal class NetworkResponseCall<S : Any, E : Any>(
    private val delegate: Call<S>,
    private val errorConverter: Converter<ResponseBody, E>
) : Call<NetworkResponse<S, E>> {
    override fun clone(): Call<NetworkResponse<S, E>> =
        NetworkResponseCall(delegate.clone(), errorConverter)

    override fun execute(): Response<NetworkResponse<S, E>> =
        throw UnsupportedOperationException("NetworkResponseCall doesn't support execute")

    override fun enqueue(callback: Callback<NetworkResponse<S, E>>) {
        return delegate.enqueue(object : Callback<S> {
            override fun onResponse(call: Call<S>, response: Response<S>) {
                val body = response.body()
                val code = response.code()
                val error = response.errorBody()
                //Callback<T> 파일 주석을 보면
                //response가 404 or 500 에러가 있을수 있다고 하니 이를 거르기 위해
                //if(response.isSuccessful)분기 처리 해줌.

                //void boolean isSuccessful(){
                // return code >= 200 && code < 300
                //}
                if (response.isSuccessful) {
                    if (body != null) {
                        callback.onResponse(
                            this@NetworkResponseCall, Response.success(
                                NetworkResponse.Success(body)
                            )
                        )
                    } else {
                        // response is successful but the body is null
                        callback.onResponse(
                            this@NetworkResponseCall, Response.success(
                                NetworkResponse.UnknownError(null)
                            )
                        )
                    }
                } else {
                    val errorBody = when {
                        error == null -> null
                        error.contentLength() == 0L -> null
                        else -> try {
                            errorConverter.convert(error)
                        } catch (e: Exception) {
                            null
                        }
                    }
                    if (errorBody != null) {
                        callback.onResponse(
                            this@NetworkResponseCall, Response.success(
                                NetworkResponse.ApiError(errorBody, code)
                            )
                        )
                    } else {
                        callback.onResponse(
                            this@NetworkResponseCall, Response.success(
                                NetworkResponse.UnknownError(null)
                            )
                        )
                    }
                }
            }

            override fun onFailure(call: Call<S>, t: Throwable) {
                val networkResponse = when (t) {
                    is IOException -> NetworkResponse.NetworkError(t)
                    else -> NetworkResponse.UnknownError(t)
                }
                callback.onResponse(this@NetworkResponseCall, Response.success(networkResponse))
            }
        })
    }

    override fun isExecuted(): Boolean = delegate.isExecuted

    override fun cancel(): Unit = delegate.cancel()

    override fun isCanceled(): Boolean = delegate.isCanceled

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()

}