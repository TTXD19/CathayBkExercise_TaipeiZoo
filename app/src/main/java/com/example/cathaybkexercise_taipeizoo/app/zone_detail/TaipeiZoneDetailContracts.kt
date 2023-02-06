package com.example.cathaybkexercise_taipeizoo.app.zone_detail

import com.example.cathaybkexercise_taipeizoo.BaseViewInterface

interface TaipeiZoneDetailContracts {

    interface View: BaseViewInterface {
        fun onZoneDetailUpdate()
    }

    interface Presenter {
        suspend fun fetchZoneDetail()
    }

}