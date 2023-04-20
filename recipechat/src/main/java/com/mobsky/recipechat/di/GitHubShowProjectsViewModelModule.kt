package com.mobsky.recipechat.di

import com.mobsky.recipechat.presentation.ChatRecipeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val chatRecipeViewModelModules = module {
    viewModel {
        ChatRecipeViewModel(projectUserCase = get())
    }
}
