package com.mobsky.recipechat.data.repository.mapper

import com.mobsky.recipechat.data.network.api.model.CompletionResponse
import com.mobsky.recipechat.domain.model.Recipe

fun CompletionResponse?.toRecipe(): List<Recipe>{
    return this?.choices?.map {
        Recipe()
    } ?: listOf()
}