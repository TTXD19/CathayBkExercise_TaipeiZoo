package com.example.model.taipei_zoo


data class TaipeiZooResp(
    val limit: Int,
    val offset: Int,
    val count: Int,
    val sort: String,
    val results: List<ZooZoneDetail>
): java.io.Serializable


data class ZooZoneDetail(
    val id: Int
)
