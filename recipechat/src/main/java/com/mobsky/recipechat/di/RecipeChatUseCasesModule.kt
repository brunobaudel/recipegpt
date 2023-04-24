package com.mobsky.recipechat.di

import com.mobsky.recipechat.domain.usercase.GetRecipeUseCase
import org.koin.dsl.module

internal val chatRecipeUseCasesModules = module {

    single {
        GetRecipeUseCase(get())
    }

}
