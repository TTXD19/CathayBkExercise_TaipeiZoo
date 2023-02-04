package com.example.data.data_source.taipei_zoo

import com.example.model.BaseTaipeiZooModel
import com.example.model.taipei_zoo.TaipeiZooResp
import retrofit2.Response
import javax.inject.Inject

class TaipeiZooDataSource @Inject constructor(
    private val taipeiZooServices: TaipeiZooServices
) : ITaipeiZooDataSource {
    override suspend fun getZooZoneList(): Response<BaseTaipeiZooModel<TaipeiZooResp>> {
        return taipeiZooServices.getZooZoneList()
    }
}