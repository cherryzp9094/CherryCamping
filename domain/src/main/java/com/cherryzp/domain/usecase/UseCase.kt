package com.cherryzp.domain.usecase

import com.cherryzp.domain.result.Result

abstract class UseCase<in P, R> {

    operator fun invoke(parameter: P): Result<R> {
        return try {
            execute(parameter).let {
                Result.Success(it)
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract fun execute(parameter: P): R

}