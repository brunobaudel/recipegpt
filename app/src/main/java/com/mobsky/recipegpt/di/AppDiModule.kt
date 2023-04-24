package com.mobsky.recipegpt.di

import com.estudos.network.StartNetworkParameters
import com.estudos.network.startNetwork
import com.mobsky.recipechat.data.network.api.OpenAIGPT3NetworkApi
import com.mobsky.recipechat.di.chatRecipeModules
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import retrofit2.Retrofit

private const val apiKey = "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"

val startNetworkParameters = StartNetworkParameters(
    baseUrl = "https://api.openai.com/v1/",
    isDebug = true,
    headers = mapOf(
        "Authorization" to apiKey,
        "Content-Type" to "application/json"
    )
)

val appDiModule = module {

    single {
        get<Retrofit> {
            parametersOf(startNetworkParameters)
        }.create(OpenAIGPT3NetworkApi::class.java)
    }

}

fun getAppModules(): List<Module> =
    listOf(
        startNetwork,
        appDiModule
    ).plus(chatRecipeModules)

