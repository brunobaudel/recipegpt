package com.mobsky.recipechat.di

import com.mobsky.recipechat.data.network.OpenAIGPTNetworkNetwork
import com.mobsky.recipechat.data.network.OpenAIGPTNetworkImpl
import com.mobsky.recipechat.data.repository.OpenAIGPTRepository
import com.mobsky.recipechat.data.repository.OpenAIGPTRepositoryImpl
import org.koin.dsl.module

private val chatRecipeNetworkModules = module {
    single<OpenAIGPTNetworkNetwork> { OpenAIGPTNetworkImpl(get()) }
}

private val chatRecipeRepositoryModule = module {
    single<OpenAIGPTRepository> { OpenAIGPTRepositoryImpl(get()) }
}

val chatRecipeModules = listOf(
    chatRecipeNetworkModules,
    chatRecipeRepositoryModule,
    chatRecipeUseCasesModules,
    chatRecipeViewModelModules
)