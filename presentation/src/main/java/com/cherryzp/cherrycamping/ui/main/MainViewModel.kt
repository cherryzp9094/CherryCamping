package com.cherryzp.cherrycamping.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.cherryzp.cherrycamping.ui.base.BaseViewModel
import com.cherryzp.domain.dto.CampingDto
import com.cherryzp.domain.usecase.camping.GetCampingListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.cherryzp.domain.result.Result
import kotlinx.coroutines.flow.*

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCampingListUseCase: GetCampingListUseCase
): BaseViewModel() {

    private val _eventFlow = MutableStateFlow<MainEvent>(MainEvent.NONE)
    val eventFlow: StateFlow<MainEvent> get() = _eventFlow

    private val _campingDtoList =  MutableLiveData<List<CampingDto>>()
    val campingDtoList: LiveData<List<CampingDto>>
        get() = _campingDtoList

    fun getCampingPagingList() {
        viewModelScope.launch {
            when(val response = getCampingListUseCase(20)) {
                is Result.Success -> {
                    response.data.cachedIn(viewModelScope).collect {
                        _eventFlow.value = MainEvent.CampingData(it)
                    }
                }
                else -> {

                }
            }
        }

    }
}