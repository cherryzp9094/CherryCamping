package com.cherryzp.cherrycamping.ui

import androidx.paging.PagingData
import com.cherryzp.domain.dto.CampingDto

sealed class MainState {
    data class CampingData(val item: PagingData<CampingDto>): MainState()
}