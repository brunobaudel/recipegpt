package com.mobsky.recipechat.data.repository

import com.mobsky.recipechat.data.network.OpenAIGPTNetworkNetwork
import com.estudos.network.util.getSuccessResultWrapper
import com.estudos.network.util.result
import com.mobsky.recipechat.data.network.api.model.CompletionRequest
import com.mobsky.recipechat.data.repository.mapper.toRecipe
import com.mobsky.recipechat.domain.model.Recipe


class OpenAIGPTRepositoryImpl(
    private val openAIGPTNetworkNetwork: OpenAIGPTNetworkNetwork
) : OpenAIGPTRepository {

    override suspend fun getCompletion(requestBody: CompletionRequest): List<Recipe> = result {
        openAIGPTNetworkNetwork
            .getCompletion(requestBody)
            .getSuccessResultWrapper()
            .toRecipe()
    }


}