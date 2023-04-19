package com.estudos.githubshowprojects.presentation.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import com.estudos.githubshowprojects.data.repository.model.ProjectInfo
import com.estudos.githubshowprojects.databinding.CardDetailGithubProjectViewBinding

class CardDetailGithubProjectView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(
    context, attrs, defStyleAttr
) {

    private val binding by lazy {
        CardDetailGithubProjectViewBinding
            .inflate(LayoutInflater.from(context), this, true)
    }

    var projectInfo: ProjectInfo? = null
        set(value) {
            field = value
            binding.ivPhotoProfile.loadImageUrl(projectInfo?.photoUser.orEmpty())
            binding.tvAuthorName.text = projectInfo?.authorName
            binding.tvForkCount.text = " ${projectInfo?.getForkCountFormat()} "
            binding.tvStarCount.text = " ${projectInfo?.getStarCountFormat()} "
            binding.tvRepositoryName.text = projectInfo?.repositoryName
        }

    init {
        layoutParams =
            LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

}