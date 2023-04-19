package com.mobsky.recipechat.data.network.api.model

import com.google.gson.annotations.SerializedName

/**
 *  id: ID único atribuído à solicitação de completude.
 *  created: data e hora em que a solicitação foi criada.
 *  model: nome do modelo GPT-3 usado para gerar a completude.
 *  choices: uma lista de objetos Choice, que contêm as informações sobre a
 *  completude gerada pelo modelo.
 */
data class CompletionResponse(
    @SerializedName("id") val id: String,
    @SerializedName("object") val objectStr: String,
    @SerializedName("created") val created: Long,
    @SerializedName("model") val model: String,
    @SerializedName("choices") val choices: List<Choice>
)

/**
 * text: o texto gerado pelo modelo para a completude.
 * index: a posição da completude na lista de completudes geradas pelo modelo.
 * logprobs: informações de log-probabilidade do texto gerado.
 * finish_reason: a razão pela qual a completude foi encerrada, como "completude máxima atingida"
 * ou "tempo limite atingido".
 * prompt: o prompt original fornecido à API para gerar a completude.
 * completions: o número de completudes geradas pelo modelo.
 * selected_text: o texto selecionado pelo usuário como a opção final de completude (opcional).
 */
data class Choice(
    @SerializedName("text") val text: String,
    @SerializedName("index") val index: Int,
    @SerializedName("logprobs") val logProbs: LogProbs,
    @SerializedName("finish_reason") val finishReason: String
)

/**
 * tokens: uma lista de strings que representam os tokens na completude gerada pelo modelo.
 * token_logprobs: uma lista de valores de log-probabilidade para cada token na lista de tokens.
 * text_offset: a posição inicial de cada token no texto original fornecido à API.
 * top_logprobs: uma lista dos N principais valores de log-probabilidade para cada token, onde N é
 * um valor definido pelo usuário.
 * token_ids: uma lista de IDs de token para cada token na lista de tokens.
 * full_logprobs: um valor booleano que indica se a lista de token_logprobs contém apenas os
 * valores dos tokens ou se inclui também as log-probabilidades dos tokens gerados anteriormente.
 */
data class LogProbs(
    @SerializedName("tokens") val tokens: List<String>,
    @SerializedName("token_logprobs") val tokenLogProbs: List<Double>,
    @SerializedName("top_logprobs") val topLogProbs: List<Double>,
    @SerializedName("text_offset") val textOffset: List<Int>,
    @SerializedName("next_token") val nextToken: List<String>,
    @SerializedName("next_token_logprob") val nextTokenLogProb: List<Double>
)
