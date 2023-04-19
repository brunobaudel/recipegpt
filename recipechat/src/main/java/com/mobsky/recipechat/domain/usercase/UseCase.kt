package com.estudos.githubshowprojects.domain.usercase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class UseCase<out T, in P>  {

    abstract suspend fun run(params: P): T

    suspend operator fun invoke(params: P): T = withContext(Dispatchers.IO) {
        try {
            run(params)
        } catch (e: Throwable) {
            throw e
        }
    }

}

suspend operator fun <T> UseCase<T, Unit>.invoke(): T = this(Unit)

