package com.example.cathaybkexercise_taipeizoo.app.zone_list

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cathaybkexercise_taipeizoo.databinding.VhZoneIntroBinding
import com.example.model.taipei_zoo.ZooZoneDetail

class TaipeiZooZoneListViewHolder(
    private val binding: VhZoneIntroBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setData(zooZoneDetail: ZooZoneDetail, itemClickCallBack: ((ZooZoneDetail) -> Unit)) {
        binding.apply {
            tvArea.text = zooZoneDetail.e_name
            tvZone.text = zooZoneDetail.e_category
            tvZoneDesc.text = zooZoneDetail.e_info
            Glide.with(root.context).load(zooZoneDetail.e_pic_url).centerCrop().into(imageZone)

            btnExplore.setOnClickListener {
                itemClickCallBack.invoke(zooZoneDetail)
            }

            itemView.setOnClickListener {
                itemClickCallBack.invoke(zooZoneDetail)
            }
        }
    }
}