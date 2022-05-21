package com.cherryzp.cherrycamping.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cherryzp.cherrycamping.databinding.ItemCampingRecyclerBinding
import com.cherryzp.domain.model.Camping

class CampingRecyclerAdapter: ListAdapter<Camping, CampingRecyclerAdapter.VH>(DiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            ItemCampingRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    inner class VH(binding: ItemCampingRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(camping: Camping) {

        }
    }

    private class DiffCallback: DiffUtil.ItemCallback<Camping>() {
        override fun areItemsTheSame(oldItem: Camping, newItem: Camping): Boolean {
            return oldItem.addr1 == newItem.addr1
        }

        override fun areContentsTheSame(oldItem: Camping, newItem: Camping): Boolean {
            return oldItem.addr1 == newItem.addr1
        }

    }
}