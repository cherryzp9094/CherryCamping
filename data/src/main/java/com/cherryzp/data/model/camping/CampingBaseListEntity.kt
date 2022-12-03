package com.cherryzp.data.model.camping

data class CampingBaseListEntity<T> (
    val items: Items<T>?
) {
    data class Items<T> (
        val item: List<T>?
    )
}