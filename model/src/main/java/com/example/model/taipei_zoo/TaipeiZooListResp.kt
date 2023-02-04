package com.example.model.taipei_zoo

import java.io.Serializable

data class TaipeiZooResp(
    val limit: Int,
    val offset: Int,
    val count: Int,
    val sort: String,
    val results: List<ZooZoneDetail>
) : Serializable


data class ZooZoneDetail(
    val id: Int,
    val e_no: Int,
    val e_category: String,
    val e_name: String,
    val e_pic_url: String,
    val e_info: String
) : Serializable
