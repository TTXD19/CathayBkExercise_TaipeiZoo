package com.example.cathaybkexercise_taipeizoo.app.zone_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.cathaybkexercise_taipeizoo.BaseFragment
import com.example.cathaybkexercise_taipeizoo.app.TaipeiZooActivityHandler
import com.example.cathaybkexercise_taipeizoo.databinding.FragmentTaipeiZooZoneDetailBinding
import com.example.model.taipei_zoo.PlantDetail
import com.example.model.taipei_zoo.PlantDetailResp
import com.example.model.taipei_zoo.ZooZoneDetail
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TaipeiZoneDetailFragment(
    private val zooZoneDetail: ZooZoneDetail
) : BaseFragment(), TaipeiZoneDetailContracts.View {

    private lateinit var binding: FragmentTaipeiZooZoneDetailBinding
    private val taipeiZooDetailPresenter: TaipeiZoneDetailPresenter by lazy {
        TaipeiZoneDetailPresenter(this)
    }
    private val onItemClickCallBack: ((PlantDetail) -> Unit) = {
        getActivityHandler(TaipeiZooActivityHandler::class.java)?.goPlantDetail(it)
    }
    private val taipeiPlantDetailAdapter: TaipeiPlantDetailAdapter by lazy {
        TaipeiPlantDetailAdapter(onItemClickCallBack)
    }

    companion object {
        fun newInstance(zooZoneDetail: ZooZoneDetail): TaipeiZoneDetailFragment {
            return TaipeiZoneDetailFragment(zooZoneDetail)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaipeiZooZoneDetailBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initData()
    }

    private fun initView() {
        binding.apply {
            tvZoneTitle.text = zooZoneDetail.e_name
            tvZoneArea.text = zooZoneDetail.e_category
            tvZoneDesc.text = zooZoneDetail.e_info
            rvPlantDetails.adapter = taipeiPlantDetailAdapter
            Glide.with(root.context).load(zooZoneDetail.e_pic_url).centerCrop().into(imageZone)
        }

    }

    private fun initData() {
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            taipeiZooDetailPresenter.fetchZoneDetail()
        }
    }

    override fun onZoneDetailUpdate(response: PlantDetailResp) {
        val filteredPlants =
            response.results.filter { it.getLocationList().contains(zooZoneDetail.e_name) }
        taipeiPlantDetailAdapter.submitList(filteredPlants)
    }
}