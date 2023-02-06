package com.example.data.repository.taipei_zoo

import com.example.data.data_source.DataResult
import com.example.model.taipei_zoo.PlantDetailResp
import com.example.model.taipei_zoo.TaipeiZooResp

interface ITaipeiZooRepository {
    suspend fun getZooZoneList(): DataResult<TaipeiZooResp>
    suspend fun getZonePlantDetails(offset: Int, limit: Int): DataResult<PlantDetailResp>
}