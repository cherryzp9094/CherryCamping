package com.cherryzp.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import com.cherryzp.domain.result.Result
import kotlinx.coroutines.withContext

abstract class UseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(parameter: P): Result<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameter).let {
                    Result.Success(it)
                }
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameter: P): R

}