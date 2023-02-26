package com.cherryzp.data.remote.model.camping

data class CampingBaseListData<T>(
    val items: Items<T>?
) {
    data class Items<T>(
        val item: List<T>?
    )
}