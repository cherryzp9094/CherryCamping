package com.cherryzp.cherrycamping.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.cherryzp.cherrycamping.R
import com.cherryzp.cherrycamping.base.BaseActivity
import com.cherryzp.cherrycamping.databinding.ActivityMainBinding
import com.cherryzp.data.BuildConfig
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_main

    private val viewmodel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupCampingItem()
        initCampingRecyclerAdapter()

        viewmodel.getCampingList()
    }

    private fun initCampingRecyclerAdapter() {
        binding.rvCampingList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = CampingRecyclerAdapter()
        }
    }

    private fun setupCampingItem() {
        viewmodel.campingList.observe(this) {
            (binding.rvCampingList.adapter as CampingRecyclerAdapter).submitList(it)
        }
    }
}