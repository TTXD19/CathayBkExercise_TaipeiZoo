package com.example.cathaybkexercise_taipeizoo.app.zone_list

import com.example.cathaybkexercise_taipeizoo.BaseViewInterface
import com.example.model.taipei_zoo.TaipeiZooResp

interface TaipeiZooZoneListContracts {

    interface View: BaseViewInterface{
        fun onTaipeiZooZoneListUpdate(taipeiZooResp: TaipeiZooResp)
        fun onTaipeiZooZoneListUpdateFailed()
    }

    interface Presenter{
        suspend fun fetchTaipeiZooZoneList()
    }
}