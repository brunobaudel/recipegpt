package com.mobsky.recipechat.data.network.api

import com.mobsky.recipechat.data.network.api.model.CompletionRequest
import com.mobsky.recipechat.data.network.api.model.CompletionResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface OpenAIGPT3NetworkApi {

    @POST("completions")
    suspend fun getCompletion(@Body requestBody: CompletionRequest): CompletionResponse

}