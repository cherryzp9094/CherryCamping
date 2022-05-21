package com.cherryzp.cherrycamping.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cherryzp.cherrycamping.BuildConfig
import com.cherryzp.cherrycamping.base.BaseViewModel
import com.cherryzp.domain.model.Camping
import com.cherryzp.domain.usecase.camping.GetCampingListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCampingListUseCase: GetCampingListUseCase
): BaseViewModel() {

    private val _campingList =  MutableLiveData<List<Camping>>()
    val campingList: LiveData<List<Camping>>
        get() = _campingList

    fun getCampingList() {
            CoroutineScope(Dispatchers.IO).launch {
                _campingList.postValue(getCampingListUseCase.excute(
                    20,
                    1,
                    "AND",
                    "AppTest"
                ))
            }
    }
}