package com.example.data.data_source.taipei_zoo

import retrofit2.Response
import javax.inject.Inject

class TaipeiZooDataSource @Inject constructor(
    private val taipeiZooServices: TaipeiZooServices
) : ITaipeiZooDataSource {
    override suspend fun getZooZoneList(): Response<Any> {
        return taipeiZooServices.getZooZoneList()
    }
}