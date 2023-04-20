package com.mobsky.recipechat.data.network

import com.estudos.network.util.ResultWrapper
import com.estudos.network.util.safeApiCall
import com.mobsky.recipechat.data.network.api.OpenAIGPT3NetworkApi
import com.mobsky.recipechat.data.network.api.model.CompletionRequest
import com.mobsky.recipechat.data.network.api.model.CompletionResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class OpenAIGPTNetworkImpl(
    private val openAIGPT3NetworkApi: OpenAIGPT3NetworkApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : OpenAIGPTNetworkNetwork {

    override suspend fun getCompletion(requestBody: CompletionRequest): ResultWrapper<CompletionResponse> =
        safeApiCall(
            dispatcher = dispatcher,
            apiCall = {
                openAIGPT3NetworkApi.getCompletion(requestBody)
            },
            transformError = {
                ""
//               Gson().fromJson(it, GitHubErrorModel::class.java).message
            }
        )
}
