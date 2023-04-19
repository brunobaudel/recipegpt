package com.mobsky.recipechat.data.repository

import com.mobsky.recipechat.data.repository.model.ProjectInfo

interface GitHubShowRepository {
    suspend fun getProjects(page: Int): List<ProjectInfo>
}