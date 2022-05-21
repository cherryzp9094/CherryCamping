package com.cherryzp.cherrycamping.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity<T : ViewDataBinding>: AppCompatActivity(), CoroutineScope {

    abstract val layoutId: Int

    protected lateinit var binding: T

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind(layoutId)

    }

    private fun bind(layoutId: Int) {
        binding = DataBindingUtil.setContentView(this, layoutId)
    }

    override fun onDestroy() {
        super.onDestroy()
        cancelJob()
    }

    private fun cancelJob() {
        job.cancel()
    }

}