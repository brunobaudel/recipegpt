package com.mobsky.recipechat.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

sealed class ViewerUiState<out T> {
    data class Success<out R>(val value: R) : ViewerUiState<R>()
    data class Loading(val isLoad: Boolean = false) : ViewerUiState<Nothing>()
    data class Error(val cause: Throwable) : ViewerUiState<Nothing>()
}

data class ExecuteStates<T>(
    val load: ((isLoad: Boolean) -> Unit)? = null,
    val success: ((T) -> Unit)? = null,
    val error: ((exception: Throwable) -> Unit)? = null
)

fun <T> ViewModel.executeSuspendedFunctionWithLoadState(
    executeStates: ExecuteStates<T>? = null,
    suspendedFun: suspend () -> T
): Job {

    val errorCoroutineHandler = CoroutineExceptionHandler { _, exception ->
        executeStates?.error?.invoke(exception)
    }

    return viewModelScope.launch(errorCoroutineHandler) {

        withContext(Dispatchers.Main) {
            executeStates?.load?.invoke(true)
        }

        val result = suspendedFun.invoke()

        withContext(Dispatchers.Main) {
            executeStates?.success?.invoke(result)
            executeStates?.load?.invoke(false)
        }
    }
}
