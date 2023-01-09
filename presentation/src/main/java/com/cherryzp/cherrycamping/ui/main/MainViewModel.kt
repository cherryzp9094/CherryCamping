package com.cherryzp.cherrycamping.ui.main

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.cherryzp.cherrycamping.ui.base.BaseViewModel
import com.cherryzp.domain.result.Result
import com.cherryzp.domain.usecase.camping.GetCampingListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCampingListUseCase: GetCampingListUseCase
): BaseViewModel() {

    private val _eventFlow = MutableStateFlow<MainEvent>(MainEvent.NONE)
    val eventFlow: StateFlow<MainEvent> get() = _eventFlow.asStateFlow()

    fun getCampingPagingList() {
        viewModelScope.launch {
            when (val response = getCampingListUseCase(20)) {
                is Result.Success -> {
                    response.data.cachedIn(viewModelScope).flowOn(Dispatchers.IO)
                        .collect { pagingData ->
                            _eventFlow.emit(MainEvent.CampingData(pagingData))
                        }
                }
                is Result.Error -> {
                    transferError(response.exception.message)
                }
                else -> {
                    _eventFlow.emit(MainEvent.NONE)
                }
            }
        }

    }
}