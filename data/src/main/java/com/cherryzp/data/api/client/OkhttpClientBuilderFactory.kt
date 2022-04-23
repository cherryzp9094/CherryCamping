package com.cherryzp.data.api.client

import com.cherryzp.data.BuildConfig
import okhttp3.OkHttpClient

class OkhttpClientBuilderFactory {
    private val okhttpClient by lazy(LazyThreadSafetyMode.NONE) {
        OkHttpClient()
    }

    private val defaultHttpClientConfigurator by lazy(LazyThreadSafetyMode.NONE) {
        DefaultOkhttpClientConfigurator(isDebug = BuildConfig.DEBUG)
    }

    fun create(configurator: OkhttpClientConfigurator? = null): OkHttpClient.Builder =
        okhttpClient.newBuilder().apply {
            configurator?.configure(this)
                ?: defaultHttpClientConfigurator.configure(this)
        }

    companion object {
        private var instance: OkhttpClientBuilderFactory? = null

        fun getInstance() =
            instance
                ?: synchronized(this) {
                    instance
                        ?: OkhttpClientBuilderFactory().apply {
                            instance = this
                        }
                }
    }
}