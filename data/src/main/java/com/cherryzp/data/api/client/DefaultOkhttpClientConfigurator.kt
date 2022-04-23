package com.cherryzp.data.api.client

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

open class DefaultOkhttpClientConfigurator(
    private vararg val interceptors: Interceptor,
    isDebug: Boolean
): OkhttpClientConfigurator {

    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (isDebug) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }

    override fun configure(httpClientBuilder: OkHttpClient.Builder) {
        httpClientBuilder
            .connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .let { builder ->
                interceptors.forEach {
                    builder.addInterceptor(it)
                }
            }
    }

    companion object {
        private const val HTTP_READ_TIMEOUT = 10L
        private const val HTTP_CONNECT_TIMEOUT = 10L
    }
}