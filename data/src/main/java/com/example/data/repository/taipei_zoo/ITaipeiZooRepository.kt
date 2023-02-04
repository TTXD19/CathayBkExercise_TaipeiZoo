package com.example.data.repository.taipei_zoo

import com.example.data.data_source.DataResult
import com.example.model.taipei_zoo.TaipeiZooResp

interface ITaipeiZooRepository {
    suspend fun getZooZoneList(): DataResult<TaipeiZooResp>
}