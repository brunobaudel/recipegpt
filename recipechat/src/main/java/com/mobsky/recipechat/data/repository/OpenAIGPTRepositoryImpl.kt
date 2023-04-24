package com.mobsky.recipechat.data.repository

import com.estudos.network.util.getSuccessResultWrapper
import com.estudos.network.util.result
import com.mobsky.recipechat.data.network.OpenAIGPTNetwork
import com.mobsky.recipechat.data.network.api.OpenAIGPT3NetworkApi
import com.mobsky.recipechat.data.network.api.model.CompletionRequest
import com.mobsky.recipechat.data.repository.mapper.toRecipe
import com.mobsky.recipechat.domain.model.Recipe

class OpenAIGPTRepositoryImpl(
    private val openAIGPTNetwork: OpenAIGPTNetwork
) : OpenAIGPTRepository {

    override suspend fun getCompletion(requestBody: CompletionRequest): List<Recipe> = result {
        openAIGPTNetwork
            .getCompletion(requestBody)
            .getSuccessResultWrapper()
            .toRecipe()
    }

}