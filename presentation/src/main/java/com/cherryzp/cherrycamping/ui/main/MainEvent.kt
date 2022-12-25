package com.cherryzp.cherrycamping.ui.main

import androidx.paging.PagingData
import com.cherryzp.domain.dto.CampingDto

sealed class MainEvent {
    object NONE : MainEvent()
    data class CampingData(val item: PagingData<CampingDto>): MainEvent()
}