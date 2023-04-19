package com.mobsky.recipegpt.di

import com.estudos.network.StartNetworkParameters
import com.estudos.network.startNetwork
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import retrofit2.Retrofit

val startNetworkParameters = StartNetworkParameters(
    baseUrl = "https://api.openai.com/v1/",
    isDebug = true
)

val appDiModule = module {

    single {
        get<Retrofit> {
            parametersOf(startNetworkParameters)
        }//.create(GitHubShowProjectsNetworkApi::class.java)
    }

}

fun getAppModules(): List<Module> =
    listOf(
        startNetwork,
        appDiModule
    )

