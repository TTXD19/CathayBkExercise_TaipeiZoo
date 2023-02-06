package com.example.cathaybkexercise_taipeizoo.app.zone_detail

import com.example.cathaybkexercise_taipeizoo.BaseViewInterface
import com.example.model.taipei_zoo.PlantDetailResp

interface TaipeiZoneDetailContracts {

    interface View: BaseViewInterface {
        fun onZoneDetailUpdate(response: PlantDetailResp)
    }

    interface Presenter {
        suspend fun fetchZoneDetail()
    }

}