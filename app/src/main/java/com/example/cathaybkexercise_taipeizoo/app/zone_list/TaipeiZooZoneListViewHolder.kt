package com.example.cathaybkexercise_taipeizoo.app.zone_list

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cathaybkexercise_taipeizoo.databinding.VhZoneIntroBinding
import com.example.model.taipei_zoo.ZooZoneDetail

class TaipeiZooZoneListViewHolder(
    private val binding: VhZoneIntroBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setData(zooZoneDetail: ZooZoneDetail, itemClickCallBack: (() -> Unit)) {
        binding.apply {
            tvArea.text = zooZoneDetail.e_category
            tvZone.text = zooZoneDetail.e_name
            tvZoneDesc.text = zooZoneDetail.e_info
            btnExplore.isVisible = zooZoneDetail.isItemExpand
            tvZoneDesc.maxLines = if (zooZoneDetail.isItemExpand) 10 else 3
            Glide.with(root.context).load(zooZoneDetail.e_pic_url).centerCrop().into(imageZone);

            itemView.setOnClickListener {
                itemClickCallBack.invoke()
            }
        }
    }
}