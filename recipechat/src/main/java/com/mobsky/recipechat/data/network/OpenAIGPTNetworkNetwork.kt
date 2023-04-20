package com.mobsky.recipechat.data.network

import com.estudos.network.util.ResultWrapper
import com.mobsky.recipechat.data.network.api.model.CompletionRequest
import com.mobsky.recipechat.data.network.api.model.CompletionResponse

interface OpenAIGPTNetworkNetwork {
    suspend fun getCompletion(requestBody: CompletionRequest): ResultWrapper<CompletionResponse>
}