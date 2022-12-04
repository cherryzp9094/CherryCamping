package com.cherryzp.data.entitiy.camping

data class CampingBaseListEntity<T> (
    val items: Items<T>?
) {
    data class Items<T> (
        val item: List<T>?
    )
}