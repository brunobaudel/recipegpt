package com.mobsky.recipechat.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val gitHubShowProjectsViewModelModules = module {
    viewModel {
        ShowProjectsViewModel(projectUserCase = get())
    }
}
