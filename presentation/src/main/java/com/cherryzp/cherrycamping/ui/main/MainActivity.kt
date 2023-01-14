package com.cherryzp.cherrycamping.ui.main

import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.cherryzp.cherrycamping.R
import com.cherryzp.cherrycamping.databinding.ActivityMainBinding
import com.cherryzp.cherrycamping.ui.CampingRecyclerAdapter
import com.cherryzp.cherrycamping.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_main

    private val viewModel: MainViewModel by viewModels()

    private val campingAdapter = CampingRecyclerAdapter()

    private fun initCampingRecyclerAdapter() {
        binding.rvCampingList.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2, GridLayoutManager.VERTICAL, false)
            adapter = campingAdapter
        }
    }

    private fun setupCampingItem() {

    }

    override fun beforeBinding() {
        initCampingRecyclerAdapter()
        setupCampingItem()
    }

    override fun afterBinding() {
        viewModel.getCampingPagingList()
    }
}