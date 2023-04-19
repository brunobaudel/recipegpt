package com.mobsky.recipechat.presentation

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.estudos.githubshowprojects.data.repository.model.ProjectInfo
import com.estudos.githubshowprojects.domain.model.ProjectInfoPage
import com.estudos.githubshowprojects.domain.usercase.GetProjectUseCase
import com.mobsky.recipechat.presentation.util.ExecuteStates
import com.mobsky.recipechat.presentation.util.ViewerUiState
import com.mobsky.recipechat.presentation.util.executeSuspendedFunctionWithLoadState
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

typealias VRListProjectInfo = ViewerUiState<List<ProjectInfo>>

class ShowProjectsViewModel(private val projectUserCase: GetProjectUseCase) : ViewModel(),
    DefaultLifecycleObserver {

    private val _vrListProjectInfo = MutableLiveData<VRListProjectInfo>()
    val vrListProjectInfo: LiveData<VRListProjectInfo> = _vrListProjectInfo

    private var currentPage = 0
    private var load = false

    fun getProjects() = runBlocking {
        launch {
            if (!load) {
                currentPage++
                load = true
                val executeStates = ExecuteStates<ProjectInfoPage>(
                    load = {
                        _vrListProjectInfo.value = ViewerUiState.Loading(it)
                    },
                    success = {
                        currentPage = it.pageCount
                        _vrListProjectInfo.value = ViewerUiState.Success(it.listProjectInfo)
                        load = false
                    },
                    error = {
                        _vrListProjectInfo.value = ViewerUiState.Error(it)
                        currentPage--
                        load = false
                    }
                )
                executeSuspendedFunctionWithLoadState(executeStates) {
                    projectUserCase.invoke(currentPage)
                }
            }
        }
    }

    override fun onCreate(owner: LifecycleOwner) {
        getProjects()
    }

}