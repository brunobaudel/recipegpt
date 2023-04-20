package com.mobsky.recipechat.presentation

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.mobsky.recipechat.domain.usercase.GetRecipeUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ChatRecipeViewModel(private val projectUserCase: GetRecipeUseCase) : ViewModel(),
    DefaultLifecycleObserver {

    fun getRecipe() = runBlocking {
        launch {

        }
    }

    override fun onCreate(owner: LifecycleOwner) {

    }

}