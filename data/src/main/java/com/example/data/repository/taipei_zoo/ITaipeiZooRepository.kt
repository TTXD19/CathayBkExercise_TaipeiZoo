package com.example.data.repository.taipei_zoo

interface ITaipeiZooRepository {
    suspend fun getZooZoneList(): String
}