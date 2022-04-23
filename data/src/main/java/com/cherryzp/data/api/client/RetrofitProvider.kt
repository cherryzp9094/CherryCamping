package com.cherryzp.data.api.client

import com.cherryzp.data.BuildConfig
import com.cherryzp.data.api.createOkhttpClientBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideRetrofit(): Retrofit =
    Retrofit.Builder()
        .client(createOkhttpClientBuilder())
        .baseUrl(BuildConfig.GO_CAMPING_SERVER_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()