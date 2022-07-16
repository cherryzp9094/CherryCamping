package com.cherryzp.cherrycamping.extends

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.cherryzp.cherrycamping.R

@BindingAdapter("urlImage")
fun ImageView.setUrlImage(imgResource: String?) {
    Glide.with(this).load(imgResource).placeholder(R.drawable.ic_launcher_background).into(this)
}
