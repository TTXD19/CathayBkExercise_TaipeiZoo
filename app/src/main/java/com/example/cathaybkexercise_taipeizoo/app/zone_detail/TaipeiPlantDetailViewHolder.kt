package com.example.cathaybkexercise_taipeizoo.app.zone_detail

import androidx.recyclerview.widget.RecyclerView
import com.example.cathaybkexercise_taipeizoo.databinding.VhPlantDetailBinding
import com.example.model.taipei_zoo.PlantDetail

class TaipeiPlantDetailViewHolder(
    private val binding: VhPlantDetailBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setData(plant: PlantDetail){
        binding.tvPlantName.text = plant.id.toString()
    }
}