package com.mobsky.recipechat.di

import com.estudos.githubshowprojects.di.gitHubShowProjectsUseCasesModules
import com.mobsky.recipechat.data.network.OpenAIGPTNetworkNetwork
import com.mobsky.recipechat.data.network.OpenAIGPTNetworkImpl
import com.mobsky.recipechat.data.repository.GitHubShowRepository
import com.mobsky.recipechat.data.repository.GitHubShowRepositoryImpl
import org.koin.dsl.module

private val openAIGPTNetworkNetworkingModules = module {
    single<OpenAIGPTNetworkNetwork> { OpenAIGPTNetworkImpl(get()) }
}

private val gitHubShowProjectsRepositoryModule = module {
    single<GitHubShowRepository> { GitHubShowRepositoryImpl(get()) }
}

val gitHubShowProjectsModules = listOf(
    openAIGPTNetworkNetworkingModules,
    gitHubShowProjectsRepositoryModule,
    gitHubShowProjectsUseCasesModules,
    gitHubShowProjectsViewModelModules
)