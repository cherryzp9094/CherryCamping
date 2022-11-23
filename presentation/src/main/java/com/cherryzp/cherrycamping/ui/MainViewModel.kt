package com.cherryzp.cherrycamping.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.cherryzp.cherrycamping.base.BaseViewModel
import com.cherryzp.domain.dto.CampingDto
import com.cherryzp.domain.usecase.camping.GetCampingListUseCase
import com.cherryzp.domain.usecase.camping.GetCampingRequestParameter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.cherryzp.domain.result.Result
import kotlinx.coroutines.flow.collect

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCampingListUseCase: GetCampingListUseCase
): BaseViewModel() {

    private val _state = MutableLiveData<MainState>()
    val state: LiveData<MainState> get() = _state

    private val _campingDtoList =  MutableLiveData<List<CampingDto>>()
    val campingDtoList: LiveData<List<CampingDto>>
        get() = _campingDtoList

    fun getCampingList() {
//            CoroutineScope(Dispatchers.IO).launch {
//                _campingDtoList.postValue(getCampingListUseCase.execute(
//                    20,
//                    1,
//                    "AND",
//                    "AppTest"
//                ))
//            }
    }

    fun getCampingPagingList() {
        viewModelScope.launch {
            when(val response = getCampingListUseCase(GetCampingRequestParameter(20, "AND", "AppTest"))) {
                is Result.Success -> {
                    response.data.cachedIn(viewModelScope).collect {
                        _state.value = MainState.CampingData(it)
                    }
                }
                else -> {

                }
            }
        }

    }
}