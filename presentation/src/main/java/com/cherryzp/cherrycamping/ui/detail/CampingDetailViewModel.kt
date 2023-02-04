package com.cherryzp.cherrycamping.ui.detail

import androidx.lifecycle.SavedStateHandle
import com.cherryzp.cherrycamping.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CampingDetailViewModel @Inject constructor(
    val stateHandle: SavedStateHandle
) : BaseViewModel() {


}