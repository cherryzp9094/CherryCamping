package com.cherryzp.cherrycamping.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cherryzp.cherrycamping.utils.loading.LoadingState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

open class BaseViewModel: ViewModel() {
    private val _errorMessage = MutableSharedFlow<String>()
    val errorMessage: SharedFlow<String> get() = _errorMessage.asSharedFlow()

    @Inject
    lateinit var loadingState: LoadingState

    fun showLoading() = loadingState.showLoading()

    fun hideLoading() = loadingState.hideLoading()

    protected fun viewModelLaunch(callFunc: suspend () -> Unit) =
        viewModelScope.launch {
            callFunc.invoke()
        }

    protected fun transferError(errorMessage: String?) {
        viewModelScope.launch {
            errorMessage?.let {
                _errorMessage.emit(it)
            }
        }
    }
}