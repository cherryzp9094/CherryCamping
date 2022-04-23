package com.cherryzp.data.api.client

import okhttp3.OkHttpClient

interface OkhttpClientConfigurator {

    fun configure(httpClientBuilder: OkHttpClient.Builder)

}