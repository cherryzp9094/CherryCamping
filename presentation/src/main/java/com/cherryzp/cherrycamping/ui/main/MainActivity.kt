package com.cherryzp.cherrycamping.ui.main

import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.cherryzp.cherrycamping.R
import com.cherryzp.cherrycamping.databinding.ActivityMainBinding
import com.cherryzp.cherrycamping.extends.repeatOnStarted
import com.cherryzp.cherrycamping.ui.CampingRecyclerAdapter
import com.cherryzp.cherrycamping.ui.base.BaseBindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseBindingActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutId: Int
        get() = R.layout.activity_main

    override val viewModel by viewModels<MainViewModel>()

    private val campingAdapter = CampingRecyclerAdapter()

    private fun initCampingRecyclerAdapter() {
        binding.rvCampingList.apply {
            layoutManager =
                GridLayoutManager(this@MainActivity, 2, GridLayoutManager.VERTICAL, false)
            adapter = campingAdapter
        }
    }

    private fun setupCampingItem() {

    }

    override fun initView() {
        viewModel.getCampingPagingList()
    }

    override fun beforeBinding() {
        initCampingRecyclerAdapter()
        setupCampingItem()
    }

    override fun afterBinding() {
        repeatOnStarted {
            viewModel.campingFlow.collect {
                campingAdapter.submitData(it)
            }
        }
    }
}