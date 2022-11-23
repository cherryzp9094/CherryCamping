package com.cherryzp.cherrycamping.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.cherryzp.cherrycamping.R
import com.cherryzp.cherrycamping.base.BaseActivity
import com.cherryzp.cherrycamping.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_main

    private val viewModel: MainViewModel by viewModels()

    private val campingAdapter = CampingRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupCampingItem()
        initCampingRecyclerAdapter()

        viewModel.getCampingPagingList()
    }

    private fun initCampingRecyclerAdapter() {
        binding.rvCampingList.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2, GridLayoutManager.VERTICAL, false)
            adapter = campingAdapter
        }
    }

    private fun setupCampingItem() {
        viewModel.state.observe(this) { state ->
            when (state) {
                is MainState.CampingData -> {
                    lifecycleScope.launch {
                        campingAdapter.submitData(state.item)
                    }
                }
            }
        }
    }
}