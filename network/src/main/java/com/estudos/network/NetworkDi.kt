package com.estudos.network

import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val startNetwork = module {
    factory {(startNetworkParameters: StartNetworkParameters)->
        Retrofit.Builder()
            .baseUrl(startNetworkParameters.baseUrl)
            .client(startNetworkParameters.getHttpClientDefault())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }
}