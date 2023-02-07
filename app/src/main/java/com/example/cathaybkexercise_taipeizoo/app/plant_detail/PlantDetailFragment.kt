package com.example.cathaybkexercise_taipeizoo.app.plant_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cathaybkexercise_taipeizoo.BaseFragment
import com.example.cathaybkexercise_taipeizoo.databinding.FragmentPlantDetailBinding
import com.example.model.taipei_zoo.PlantDetail

class PlantDetailFragment(private val plantDetail: PlantDetail) : BaseFragment() {

    private lateinit var binding: FragmentPlantDetailBinding

    companion object {
        fun newInstance(plantDetail: PlantDetail): PlantDetailFragment {
            return PlantDetailFragment(plantDetail)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlantDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        binding.apply {
            tvPlantArea.text = plantDetail.chName
            tvPlantBrief.text = plantDetail.F_Brief
            Glide.with(root.context).load(plantDetail.F_Pic01_URL).centerCrop().into(imageZone)
        }

    }
}