package com.estudos.network

import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor


typealias TimeInMileSeconds = Long

data class StartNetworkParameters(
    val baseUrl: String,
    val isDebug: Boolean = false,
    val okHttpClient: OkHttpClient? = null,
    val readTimeOut: TimeInMileSeconds = 3000,
    val writeTimeOut: TimeInMileSeconds = 3000,

) {

    fun getHttpClientDefault(): OkHttpClient = let {

        val logging = HttpLoggingInterceptor()
            .apply { level = HttpLoggingInterceptor.Level.BODY }


        val okHttpClientDefault = OkHttpClient
            .Builder().apply {

                if (isDebug)
                    addInterceptor(logging)

                readTimeout(readTimeOut, TimeUnit.MILLISECONDS)
                writeTimeout(writeTimeOut, TimeUnit.MILLISECONDS)
                addInterceptor { chain ->
                    val request: Request = chain.request().newBuilder().build()



                    chain.proceed(request)
                }
            }.build()

        okHttpClient ?: okHttpClientDefault

    }

}