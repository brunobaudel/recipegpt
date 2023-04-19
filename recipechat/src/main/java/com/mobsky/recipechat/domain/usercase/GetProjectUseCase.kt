package com.mobsky.recipechat.domain.usercase

import com.estudos.githubshowprojects.domain.model.ProjectInfoPage
import com.estudos.githubshowprojects.domain.usercase.UseCase

class GetProjectUseCase(
    private val gitHubShowRepository: GitHubShowRepository
) : UseCase<ProjectInfoPage, Int>() {

    private val projectInfoPage = ProjectInfoPage()

    override suspend fun run(pageCount: Int): ProjectInfoPage {

        return projectInfoPage
    }
}