package com.example.cathaybkexercise_taipeizoo.app.plant_detail

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.cathaybkexercise_taipeizoo.BaseFragment
import com.example.cathaybkexercise_taipeizoo.R
import com.example.cathaybkexercise_taipeizoo.app.TaipeiZooActivityHandler
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

        getActivityHandler(TaipeiZooActivityHandler::class.java)?.setToolbarAsPlantDetailUse()
        initView()
    }

    private fun initView() {
        binding.apply {
            Glide.with(root.context)
                .load(plantDetail.F_Pic01_URL)
                .placeholder(R.drawable.default_plant)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        tvPlantNoImage.isVisible = true
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        tvPlantNoImage.isVisible = false
                        return false
                    }
                })
                .centerCrop()
                .into(imagePlantDetail)
            tvPlantTitle.text = getString(R.string.plant_name, plantDetail.chName, plantDetail.F_Name_En)
            tvPlantSubtitle.text = getString(R.string.plant_name_latin, plantDetail.F_Name_Latin)
            tvPlantFamily.text = getString(R.string.plant_name_type, plantDetail.F_Family)
            tvPlantBrief.text = plantDetail.F_Brief
            tvPlantFeatureDesc.text = plantDetail.F_Feature
            tvPlantApplicationDesc.text = plantDetail.application
            tvPlantArea.text = plantDetail.F_Location
            tvPlantName.text = plantDetail.F_AlsoKnown
        }
    }
}