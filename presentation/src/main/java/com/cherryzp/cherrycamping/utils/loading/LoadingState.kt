package com.cherryzp.cherrycamping.utils.loading

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoadingState {
    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading.asStateFlow()

    fun showLoading() {
        _loading.value = true
    }

    fun hideLoading() {
        _loading.value = false
    }

    fun isLoading(): Boolean = loading.value
}