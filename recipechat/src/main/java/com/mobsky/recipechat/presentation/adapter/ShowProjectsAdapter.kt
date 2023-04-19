package com.estudos.githubshowprojects.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.estudos.githubshowprojects.data.repository.model.LoadStateProjectInfo
import com.estudos.githubshowprojects.data.repository.model.ProjectInfo
import com.estudos.githubshowprojects.databinding.CardDetailGithubProjectViewShimmerBinding
import com.estudos.githubshowprojects.databinding.ProgressListItemBinding
import com.estudos.githubshowprojects.presentation.custom_view.CardDetailGithubProjectView

class ShowProjectsAdapter :
    ListAdapter<ProjectInfo, RecyclerView.ViewHolder>(ProjectInfoDiffCallback()) {

//    var projectInfoList = mutableListOf<ProjectInfo>()
//        set(value) {
//            field.clear()
//            field.addAll(value)
//            submitList(field.toMutableList())
//        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            VIEW_TYPE_ITEM -> ShowProjectsVH(CardDetailGithubProjectView(parent.context))
            VIEW_TYPE_LOADING -> LoadingVH(
                ProgressListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> LoadingShimmerVH(
                CardDetailGithubProjectViewShimmerBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ShowProjectsVH -> holder.bind(getItem(position))
            is LoadingVH -> holder
        }
    }

    fun stateLoad(isLoad: Boolean) {
        if (isLoad) {
            startLoad()
        } else {
            stopLoad()
        }
    }

    private fun startLoad() {
        val startLoad = currentList.find { findLoadOrShimmerItem(it.load)} == null
        if (startLoad) {
            val addListLoad = mutableListOf<ProjectInfo>()
            addListLoad.addAll(currentList)
            addListLoad.add(ProjectInfo(load = LoadStateProjectInfo.Load))
            submitList(addListLoad)
        }
    }

    private fun findLoadOrShimmerItem(loadStateProjectInfo: LoadStateProjectInfo): Boolean {
        return loadStateProjectInfo == LoadStateProjectInfo.Load
                || loadStateProjectInfo == LoadStateProjectInfo.Shimmer
    }

    private fun stopLoad() {
        currentList.find { it.load == LoadStateProjectInfo.Load }?.run {
            val removeListLoad = mutableListOf<ProjectInfo>()
            removeListLoad.addAll(currentList)
            removeListLoad.remove(this)
            submitList(removeListLoad)
        }
    }

    fun startLoadShimmer() {
        if (currentList.isEmpty()) {
            submitList( (0..10).map {
                ProjectInfo(load = LoadStateProjectInfo.Shimmer)
            }.toMutableList())
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (currentList[position].load) {
            is LoadStateProjectInfo.Load -> VIEW_TYPE_LOADING
            is LoadStateProjectInfo.NoLoad -> VIEW_TYPE_ITEM
            is LoadStateProjectInfo.Shimmer -> VIEW_TYPE_LOADING_SHIMMER
        }
    }

    companion object {
        private const val VIEW_TYPE_ITEM = 0
        private const val VIEW_TYPE_LOADING = 1
        private const val VIEW_TYPE_LOADING_SHIMMER = 2
    }

    private class ShowProjectsVH(private val view: CardDetailGithubProjectView) :
        RecyclerView.ViewHolder(view) {

        fun bind(projectInfo: ProjectInfo) {
            view.projectInfo = projectInfo
        }
    }

    private class LoadingVH(itemView: ProgressListItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        fun showLoad() {

        }
    }

    private class LoadingShimmerVH(itemView: CardDetailGithubProjectViewShimmerBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        fun showLoad() {

        }
    }
}

private class ProjectInfoDiffCallback : DiffUtil.ItemCallback<ProjectInfo>() {

    override fun areItemsTheSame(oldItem: ProjectInfo, newItem: ProjectInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProjectInfo, newItem: ProjectInfo): Boolean {
        return oldItem.id == newItem.id
    }
}
