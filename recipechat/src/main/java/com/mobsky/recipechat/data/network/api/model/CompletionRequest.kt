package com.mobsky.recipechat.data.network.api.model

/**
 * engine (opcional): Especifica o mecanismo do GPT-3 a ser usado.
 * O valor padrão é davinci (que é o mecanismo mais poderoso).
 * Outros valores possíveis são:
 * curie,
 * babbage,
 * ada,
 * curie-instruct-beta,
 * davinci-instruct-beta e
 * content-filter-alpha.
 *
 * prompt (obrigatório): O prompt ou texto de entrada que o modelo GPT-3 deve usar para
 * gerar a completude. É uma string que pode conter uma ou várias frases.
 * É importante que o prompt esteja escrito em inglês.
 *
 * temperature (opcional): Controla a variabilidade da completude gerada pelo modelo.
 * É um número de ponto flutuante que varia entre 0 e 1. Quanto maior o valor, maior a variabilidade.
 * O valor padrão é 1.
 *
 * max_tokens (opcional): O número máximo de tokens (palavras) a serem gerados na completude.
 * É um número inteiro entre 1 e 2048. O valor padrão é 2048.
 *
 * top_p (opcional): Controla a probabilidade cumulativa de selecionar as próximas palavras da
 * completude. É um número de ponto flutuante entre 0 e 1. O valor padrão é 1.
 *
 * frequency_penalty (opcional): Controla a probabilidade de repetir as palavras na completude.
 * É um número de ponto flutuante que varia entre 0 e 1. Quanto maior o valor, menor a probabilidade
 * de repetir palavras. O valor padrão é 0.
 *
 * presence_penalty (opcional): Controla a probabilidade de usar palavras que não aparecem no
 * prompt na completude. É um número de ponto flutuante que varia entre 0 e 1.
 * Quanto maior o valor, menor a probabilidade de usar palavras novas. O valor padrão é 0.
 *
 * stop (opcional): Uma lista de strings que indica quando o modelo deve parar de gerar
 * a completude. O modelo irá parar de gerar a completude quando encontrar uma das strings da lista.
 * O valor padrão é ["\n", ".", "!", "?"].
 *
 * n (opcional): O número de completudes a serem geradas pelo modelo.
 * É um número inteiro entre 1 e 10. O valor padrão é 1.
 *
 * stream (opcional): Se definido como true, a resposta será retornada como um stream de texto
 * com cada nova completude gerada sendo enviada como uma linha separada. O valor padrão é false.
 *
 * logprobs (opcional): Se definido como um valor inteiro entre 1 e 50, o modelo retornará
 * informações adicionais sobre as probabilidades de cada token em cada posição na completude.
 * O valor padrão é null.
 *
 * echo (opcional): Se definido como true, o prompt é incluído na resposta. O valor padrão é false.
 *
 * stop_sequence (opcional): Especifica uma sequência personalizada de tokens que indica quando
 * o modelo deve parar de gerar a completude. É uma lista de strings.
 *
 * model (opcional): Especifica o ID do modelo GPT-3
 */
data class CompletionRequest(
    val prompt: String,
    val maxTokens: Int = 0,
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

