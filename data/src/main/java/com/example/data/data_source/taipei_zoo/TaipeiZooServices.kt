package com.example.data.data_source.taipei_zoo

import com.example.model.BaseTaipeiZooModel
import com.example.model.taipei_zoo.PlantDetailResp
import com.example.model.taipei_zoo.TaipeiZooResp
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TaipeiZooServices {
    companion object {
        private const val ZOO_LIST = "dataset/5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a"
        private const val PLANT_DETAIL = "dataset/f18de02f-b6c9-47c0-8cda-50efad621c14"
        private const val SCOPE = "resourceAquire"
    }

    @GET(ZOO_LIST)
    suspend fun getZooZoneList(
        @Query("scope") scope: String = SCOPE
    ): Response<BaseTaipeiZooModel<TaipeiZooResp>>

    @GET(PLANT_DETAIL)
    suspend fun getZonePlantDetail(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("scope") scope: String = SCOPE
    ): Response<BaseTaipeiZooModel<PlantDetailResp>>
}