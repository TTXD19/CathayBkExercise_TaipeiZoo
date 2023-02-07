package com.example.cathaybkexercise_taipeizoo.app.zone_detail

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cathaybkexercise_taipeizoo.databinding.VhPlantDetailBinding
import com.example.model.taipei_zoo.PlantDetail

class TaipeiPlantDetailViewHolder(
    private val binding: VhPlantDetailBinding,
    private val onItemClickCallBack: ((PlantDetail) -> Unit)
) : RecyclerView.ViewHolder(binding.root) {

    fun setData(plant: PlantDetail) {
        binding.tvPlantName.text = plant.chName
        Glide.with(binding.root.context).load(plant.F_Pic01_URL).centerCrop().into(binding.imagePlant)

        itemView.setOnClickListener {
            onItemClickCallBack.invoke(plant)
        }
    }
}