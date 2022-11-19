package com.cherryzp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.cherryzp.data.BuildConfig
import com.cherryzp.data.api.GoCampingService
import com.cherryzp.data.api.client.NetworkResponse
import com.cherryzp.data.mapper.camping.mapperToCamping
import com.cherryzp.domain.model.Camping
import javax.inject.Inject

class CampingPagingDataSource @Inject constructor (private val campingApi: GoCampingService): PagingSource<Int, Camping>() {
    override fun getRefreshKey(state: PagingState<Int, Camping>): Int? {
        return 0
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Camping> {
        return try {
            val page = params.key?: 0
            when (val response = campingApi.getBasedList(BuildConfig.GO_CAMPING_API_KEY, pageNo = page)) {
                is NetworkResponse.Success -> {
                    val campingList = response.body.response.body.items.item.let {
                        mapperToCamping(it)
                    }
                    val nextPage = if(campingList.count() == 20) page + 1 else null
                    LoadResult.Page(data = campingList, nextKey = nextPage, prevKey = null)
                }
                else -> {
                    LoadResult.Error(Throwable("에러"))
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

}