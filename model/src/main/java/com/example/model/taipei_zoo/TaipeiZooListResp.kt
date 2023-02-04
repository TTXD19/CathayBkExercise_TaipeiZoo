package com.example.model.taipei_zoo

import com.example.model.BaseTaipeiZooModel

data class TaipeiZooListResp(
    val results: List<ZooZoneDetail>
) : BaseTaipeiZooModel()


data class ZooZoneDetail(
    val id: Int
)
