package com.mobsky.recipechat.domain.usercase

import com.mobsky.recipechat.data.network.api.model.CompletionRequest
import com.mobsky.recipechat.data.repository.OpenAIGPTRepository
import com.mobsky.recipechat.domain.model.Recipe

class GetRecipeUseCase(
    private val openAIGPTRepository: OpenAIGPTRepository
) : UseCase<List<Recipe>, Int>() {

    override suspend fun run(pageCount: Int): List<Recipe> {
        return openAIGPTRepository.getCompletion(CompletionRequest(prompt = promptRecipe))
    }

    companion object{
        val promptRecipe = "gostaria de uma receita de . Em formato json com apenas as chaves em ingles " +
                "e o conteudo dela fosse em portugues. Preciso contar as calorias de cada ingrediente e as " +
                "calorias gerais do prato."
    }

}