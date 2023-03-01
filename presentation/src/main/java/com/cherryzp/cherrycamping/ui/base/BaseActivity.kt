package com.cherryzp.cherrycamping.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.cherryzp.cherrycamping.dialog.LoadingDialog
import com.cherryzp.cherrycamping.extends.repeatOnStarted
import com.cherryzp.cherrycamping.utils.loading.BaseInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import java.util.*
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity(), CoroutineScope,
    BaseInterface {

    abstract val layoutId: Int

    protected lateinit var binding: T

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    private var loadingDialog: LoadingDialog? = null
    private var loadingStack = Stack<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind(layoutId)

        initView()
        beforeBinding()
        afterBinding()
    }

    private fun bind(layoutId: Int) {
        binding = DataBindingUtil.setContentView(this, layoutId)

    }

    abstract fun initView()
    abstract fun beforeBinding()
    abstract fun afterBinding()

    fun setupDefaultObserver(vararg viewModels: BaseViewModel) {
        repeatOnStarted {
            viewModels.forEach { viewModel ->
                viewModel.loadingState.loading.collect {
                    if (it) showLoading() else hideLoading()
                }
            }
        }
    }

    protected open fun showLoading() {
        if (loadingDialog == null) {
            loadingDialog = LoadingDialog(this, null)
        }

        if (loadingDialog?.isShowing == false && !isFinishing) {
            loadingDialog?.show()
        }
        loadingStack.push("")
    }

    protected open fun hideLoading() {
        if (!loadingStack.isEmpty()) loadingStack.pop()
        if (loadingStack.isEmpty()) loadingDialog?.dismiss()
    }

    override fun loadingState(isShow: Boolean) {
        if (isShow) showLoading() else hideLoading()
    }

    override fun closeAllLoading() {
        while (loadingStack.isNotEmpty()) {
            hideLoading()
        }
    }

    override fun onPause() {
        super.onPause()

        closeAllLoading()
    }

    override fun onDestroy() {
        super.onDestroy()
        cancelJob()
    }

    private fun cancelJob() {
        job.cancel()
    }

}