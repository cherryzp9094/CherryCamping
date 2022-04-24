package com.cherryzp.cherrycamping.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cherryzp.cherrycamping.base.BaseViewModel
import com.cherryzp.domain.model.Camping
import com.cherryzp.domain.usecase.camping.GetCampingListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCampingListUseCase: GetCampingListUseCase
): BaseViewModel() {

    private val _campingList =  MutableLiveData<List<Camping>>()
    val campingList: LiveData<List<Camping>>
        get() = _campingList

    fun getCampingList() {

    }
}