package com.example.data.data_source.taipei_zoo

import retrofit2.Response

interface ITaipeiZooDataSource {
    suspend fun getZooZoneList(): Response<Any>
}