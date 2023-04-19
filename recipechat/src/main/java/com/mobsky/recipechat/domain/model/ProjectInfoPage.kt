package com.estudos.githubshowprojects.domain.model

import com.estudos.githubshowprojects.data.repository.model.ProjectInfo

data class ProjectInfoPage(
    var pageCount: Int = 0,
    val listProjectInfo: MutableList<ProjectInfo> = mutableListOf()
) {
    fun isPagesEmpty(): Boolean = pageCount == 0

    fun addPage() {
        pageCount++
    }
}
