package com.cherryzp.cherrycamping.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.cherryzp.cherrycamping.R

class LoadingDialog(
    mContext: Context,
    private val callback: (() -> Unit)?
) : Dialog(mContext, R.style.LoadingDialog) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setCanceledOnTouchOutside(false)
        this.setContentView(R.layout.dialog_loading)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setDimAmount(0f)

        setCancelable(false)
    }

    override fun dismiss() {
        callback?.invoke()
        super.dismiss()
    }

    fun error() {
        super.dismiss()
    }

}