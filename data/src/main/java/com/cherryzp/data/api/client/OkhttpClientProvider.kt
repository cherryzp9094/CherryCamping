package com.cherryzp.data.api

import android.util.Log
import com.cherryzp.data.BuildConfig
import com.cherryzp.data.api.client.DefaultOkhttpClientConfigurator
import com.cherryzp.data.api.client.OkhttpClientBuilderFactory
import okhttp3.OkHttpClient
import okhttp3.RequestBody

fun createOkhttpClientBuilder(): OkHttpClient =
    OkhttpClientBuilderFactory.getInstance()
        .create(
            DefaultOkhttpClientConfigurator(isDebug = BuildConfig.DEBUG)
        )
        .addInterceptor { chain ->
            val request = chain.request().newBuilder().build()
            if (BuildConfig.DEBUG) {
                val str = request.body.bodyToString()
                Log.w("RetrofitRequest", "${request.url} - $str")
            }
            chain.proceed(request)
        }.build()

private fun RequestBody?.bodyToString(): String {
    if (this == null) return ""
    val buffer = okio.Buffer()
    writeTo(buffer)
    return buffer.readUtf8()
}
