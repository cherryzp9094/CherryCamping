package com.cherryzp.cherrycamping.ui.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.cherryzp.cherrycamping.BR
import com.cherryzp.cherrycamping.extends.repeatOnStarted
import com.google.android.material.snackbar.Snackbar

abstract class BaseBindingActivity<T : ViewDataBinding, V : BaseViewModel>() : BaseActivity<T>() {
    abstract val viewModel: V
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            setVariable(BR.vm, viewModel)
            lifecycleOwner = this@BaseBindingActivity
        }
        collectError()
    }

    private fun collectError() {
        repeatOnStarted {
            viewModel.errorMessage.collect {
                Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    open fun fetchBindItem(): List<Pair<Int, Any>> = listOf()

}