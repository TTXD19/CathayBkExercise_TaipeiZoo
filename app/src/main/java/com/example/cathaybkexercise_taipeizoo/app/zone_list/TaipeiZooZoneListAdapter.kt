package com.example.cathaybkexercise_taipeizoo.app.zone_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.cathaybkexercise_taipeizoo.databinding.VhZoneIntroBinding
import com.example.model.taipei_zoo.ZooZoneDetail

class TaipeiZooZoneListAdapter : ListAdapter<ZooZoneDetail, TaipeiZooZoneListViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaipeiZooZoneListViewHolder {
        return TaipeiZooZoneListViewHolder(
            VhZoneIntroBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaipeiZooZoneListViewHolder, position: Int) {
        currentList[position]?.also {
            holder.setData(it)
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<ZooZoneDetail>() {
        override fun areItemsTheSame(oldItem: ZooZoneDetail, newItem: ZooZoneDetail): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ZooZoneDetail, newItem: ZooZoneDetail): Boolean {
            return oldItem.id == newItem.id
        }

    }

}