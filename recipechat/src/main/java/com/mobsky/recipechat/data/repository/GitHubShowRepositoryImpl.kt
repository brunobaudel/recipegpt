package com.mobsky.recipechat.data.repository

import com.mobsky.recipechat.data.network.OpenAIGPTNetworkNetwork
import com.mobsky.recipechat.data.repository.mapper.toProjectInfo
import com.mobsky.recipechat.data.repository.model.ProjectInfo
import com.estudos.network.util.getSuccessResultWrapper
import com.estudos.network.util.result


class GitHubShowRepositoryImpl(
    private val openAIGPTNetworkNetwork: OpenAIGPTNetworkNetwork
) : GitHubShowRepository {

    override suspend fun getProjects(page: Int): List<ProjectInfo> {
        return result {
            openAIGPTNetworkNetwork
                .getCompletion(page)
                .getSuccessResultWrapper()
                .toProjectInfo()
        }
    }

}