package com.estudos.network.util

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class GenericError(val code: Int? = null, val errorMessage: String) :
        ResultWrapper<Nothing>()
}

fun <T> ResultWrapper<T>.getSuccessResultWrapper(): T? =
    when (this) {
        is ResultWrapper.Success -> value
        else -> {
            val messageException = when (this) {
                is ResultWrapper.GenericError -> {
                    "Codigo: $code. $errorMessage"
                }
                else -> {
                    ""
                }
            }
            throw Exception(messageException)
        }
    }

inline fun <T> result(block: () -> T): T = try {
    block()
} catch (e: Throwable) {
    throw e
}