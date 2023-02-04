package com.example.data.data_source.taipei_zoo

import com.example.model.BaseTaipeiZooModel
import com.example.model.taipei_zoo.TaipeiZooResp
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TaipeiZooServices {
    companion object {
        private const val ZOO_LIST = "dataset/5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a"
        private const val SCOPE = "resourceAquire"
    }

    @GET(ZOO_LIST)
    suspend fun getZooZoneList(
        @Query("scope") scope: String = SCOPE
    ): Response<BaseTaipeiZooModel<TaipeiZooResp>>
}