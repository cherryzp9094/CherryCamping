package com.cherryzp.cherrycamping.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

open class BaseViewModel: ViewModel() {
    private val _errorMessage = MutableSharedFlow<String>()
    val errorMessage: SharedFlow<String> get() = _errorMessage.asSharedFlow()

    protected fun transferError(errorMessage: String?) {
        viewModelScope.launch {
            errorMessage?.let {
                _errorMessage.emit(it)
            }
        }
    }
}