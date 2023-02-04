package com.cherryzp.cherrycamping.ui.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.cherryzp.cherrycamping.BR

abstract class BaseBindingActivity<T : ViewDataBinding, V : BaseViewModel>() : BaseActivity<T>() {
    abstract val viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            setVariable(BR.vm, viewModel)
            lifecycleOwner = this@BaseBindingActivity
        }
    }

    open fun fetchBindItem(): List<Pair<Int, Any>> = listOf()

}