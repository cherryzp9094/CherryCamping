package com.cherryzp.cherrycamping.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.cherryzp.cherrycamping.R
import com.cherryzp.cherrycamping.base.BaseActivity
import com.cherryzp.cherrycamping.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_main

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupCampingItem()
        initCampingRecyclerAdapter()

        viewModel.getCampingList()
    }

    private fun initCampingRecyclerAdapter() {
        binding.rvCampingList.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2, GridLayoutManager.VERTICAL, false)
            adapter = CampingRecyclerAdapter()
        }
    }

    private fun setupCampingItem() {
        viewModel.campingList.observe(this) {
            (binding.rvCampingList.adapter as CampingRecyclerAdapter).submitList(it)
        }
    }
}