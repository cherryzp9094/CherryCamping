package com.cherryzp.domain.usecase

import com.cherryzp.domain.di.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class UseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(parameter: P): R {
        return withContext(coroutineDispatcher) {
                excute(parameter)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun excute(parameter: P): R

}