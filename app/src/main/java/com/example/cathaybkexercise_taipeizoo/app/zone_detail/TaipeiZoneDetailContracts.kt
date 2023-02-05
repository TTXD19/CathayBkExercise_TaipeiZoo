package com.example.cathaybkexercise_taipeizoo.app.zone_detail

interface TaipeiZoneDetailContracts {

    interface View {
        fun onZoneDetailUpdate()
    }

    interface Presenter {
        fun fetchZoneDetail()
    }

}