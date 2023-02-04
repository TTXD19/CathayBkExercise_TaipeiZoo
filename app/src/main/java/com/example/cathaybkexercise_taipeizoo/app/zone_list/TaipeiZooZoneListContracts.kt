package com.example.cathaybkexercise_taipeizoo.app.zone_list

import com.example.cathaybkexercise_taipeizoo.BaseViewInterface

interface TaipeiZooZoneListContracts {

    interface View: BaseViewInterface{
        fun onTaipeiZooZoneListUpdate()
    }

    interface Presenter{
        suspend fun fetchTaipeiZooZoneList()
    }
}