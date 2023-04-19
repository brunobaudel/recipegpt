package com.mobsky.recipechat.data.network.api.model

data class CompletionRequest(
    val prompt: String,
    val maxTokens: Int,
    val temperature: Double = 0.5,
    val topP: Double = 1.0,
    val frequencyPenalty: Double = 0.0,
    val presencePenalty: Double = 0.0,
    val stop: List<String>? = null,
    val n: Int = 1,
    val stream: Boolean = false,
    val logProbs: Int? = null,
    val echo: Boolean = false
)

