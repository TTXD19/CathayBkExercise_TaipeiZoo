package com.example.data.data_source.taipei_zoo

import com.example.model.BaseTaipeiZooModel
import com.example.model.taipei_zoo.PlantDetailResp
import com.example.model.taipei_zoo.TaipeiZooResp
import retrofit2.Response

interface ITaipeiZooDataSource {
    suspend fun getZooZoneList(): Response<BaseTaipeiZooModel<TaipeiZooResp>>
    suspend fun getZonePlanDetails(offset: Int, limit: Int): Response<BaseTaipeiZooModel<PlantDetailResp>>
}