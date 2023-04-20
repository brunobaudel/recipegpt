package com.mobsky.recipechat.data.repository

import com.mobsky.recipechat.data.network.api.model.CompletionRequest
import com.mobsky.recipechat.domain.model.Recipe

interface OpenAIGPTRepository {
    suspend fun getCompletion(requestBody: CompletionRequest): List<Recipe>
}