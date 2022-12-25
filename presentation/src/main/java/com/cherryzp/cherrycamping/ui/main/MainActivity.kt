package com.cherryzp.cherrycamping.ui.main

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.cherryzp.cherrycamping.R
import com.cherryzp.cherrycamping.ui.base.BaseActivity
import com.cherryzp.cherrycamping.databinding.ActivityMainBinding
import com.cherryzp.cherrycamping.extends.repeatOnStarted
import com.cherryzp.cherrycamping.ui.CampingRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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
        repeatOnStarted {
            viewModel.eventFlow.collect { state ->
                when (state) {
                    is MainEvent.CampingData -> {
                        lifecycleScope.launch {
                            campingAdapter.submitData(state.item)
                        }
                    }
                    else -> {}
                }
            }
        }
    }

    override fun beforeBinding() {
        initCampingRecyclerAdapter()
        setupCampingItem()
    }

    override fun afterBinding() {
        viewModel.getCampingPagingList()
    }
}