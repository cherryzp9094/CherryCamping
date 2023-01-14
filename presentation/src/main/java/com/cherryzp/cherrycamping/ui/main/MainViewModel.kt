package com.cherryzp.cherrycamping.ui.main

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.cherryzp.cherrycamping.ui.base.BaseViewModel
import com.cherryzp.domain.dto.CampingDto
import com.cherryzp.domain.result.Result
import com.cherryzp.domain.usecase.camping.GetCampingListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCampingListUseCase: GetCampingListUseCase
): BaseViewModel() {

    private val _eventFlow = MutableSharedFlow<MainEvent>()
    val eventFlow: SharedFlow<MainEvent> get() = _eventFlow.asSharedFlow()

    private val _campingFlow = MutableStateFlow<PagingData<CampingDto>>(PagingData.empty())
    val campingFlow: StateFlow<PagingData<CampingDto>> get() = _campingFlow.asStateFlow()

    fun getCampingPagingList() {
        viewModelScope.launch {
            when (val response = getCampingListUseCase(20)) {
                is Result.Success -> {
                    response.data.cachedIn(viewModelScope).flowOn(Dispatchers.IO)
                        .collect { pagingData ->
                            _campingFlow.emit(pagingData)
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