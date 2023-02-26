package com.cherryzp.cherrycamping.ui.detail

import androidx.activity.viewModels
import com.cherryzp.cherrycamping.R
import com.cherryzp.cherrycamping.databinding.ActivityCampingDetailBinding
import com.cherryzp.cherrycamping.ui.base.BaseBindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CampingDetailActivity :
    BaseBindingActivity<ActivityCampingDetailBinding, CampingDetailViewModel>() {
    override val viewModel: CampingDetailViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.activity_camping_detail

    override fun initView() {

    }

    override fun beforeBinding() {

    }

    override fun afterBinding() {

    }
}