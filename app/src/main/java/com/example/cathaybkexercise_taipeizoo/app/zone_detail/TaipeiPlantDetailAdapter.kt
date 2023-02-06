package com.example.cathaybkexercise_taipeizoo.app.zone_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.cathaybkexercise_taipeizoo.databinding.VhPlantDetailBinding
import com.example.model.taipei_zoo.PlantDetail

class TaipeiPlantDetailAdapter : PagingDataAdapter<PlantDetail, TaipeiPlantDetailViewHolder>(PlantComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaipeiPlantDetailViewHolder {
        return TaipeiPlantDetailViewHolder(
            VhPlantDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaipeiPlantDetailViewHolder, position: Int) {
        getItem(position)?.also { holder.setData(it) }
    }

}

class PlantComparator : DiffUtil.ItemCallback<PlantDetail>() {
    override fun areItemsTheSame(oldItem: PlantDetail, newItem: PlantDetail): Boolean {
        // Id is unique.
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PlantDetail, newItem: PlantDetail): Boolean {
        return oldItem == newItem
    }
}