package com.example.cathaybkexercise_taipeizoo.app.zone_list

interface TaipeiZooZoneListContracts {

    interface View{
        fun onTaipeiZooZoneListUpdate()
    }

    interface Presenter{
        suspend fun fetchTaipeiZooZoneList()
    }
}