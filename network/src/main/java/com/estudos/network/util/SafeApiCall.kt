package com.estudos.network.util

import java.io.IOException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T,
    transformError: ((errorBody: String) -> String)? = null
): ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is TimeoutCancellationException -> {
                    val code = 408
                    ResultWrapper.GenericError(code, NETWORK_INTERNET_STATE_ERROR_MESSAGE)
                }
                is IOException -> ResultWrapper.GenericError(
                    throwable.hashCode(), NETWORK_CONNECTION_ERROR_MESSAGE
                )
                is HttpException -> {
                    val code = throwable.code()
                    val errorResponse = convertErrorBody(throwable, transformError)
                    ResultWrapper.GenericError(code, errorResponse)
                }
                else -> {
                    ResultWrapper.GenericError(null, NETWORK_UN_KNOW_ERROR_MESSAGE)
                }
            }
        }
    }
}

private fun convertErrorBody(
    throwable: HttpException, transformError: ((errorBody: String) -> String)? = null
): String {
    return try {
        val json = throwable.response()?.errorBody()?.string().orEmpty()
        transformError?.invoke(json) ?: json
    } catch (exception: Exception) {
        throwable.response()?.errorBody()?.string().orEmpty()
    }
}

private const val NETWORK_CONNECTION_ERROR_MESSAGE =
    "Verifique se seu dispositivo esta conectado a rede."

private const val NETWORK_UN_KNOW_ERROR_MESSAGE = "Erro desconhecido."

private const val NETWORK_INTERNET_STATE_ERROR_MESSAGE = "Verifique o status da internet."


