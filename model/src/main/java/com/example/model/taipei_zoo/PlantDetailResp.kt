package com.example.model.taipei_zoo

import com.google.gson.annotations.SerializedName


data class PlantDetailResp(
    val limit: Int,
    val offset: Int,
    val count: Int,
    val sort: String,
    val results: List<PlantDetail>
)

data class PlantDetail(
    @SerializedName("_id") val id: Int,
    @SerializedName("\uFEFFF_Name_Ch") val chName: String,
    val F_AlsoKnown: String,
    val F_Location: String,
    val F_Name_En: String,
    val F_Name_Latin: String,
    val F_Brief: String,
    val F_Feature: String,
    val F_Pic01_URL: String,
    val F_Pic02_URL: String,
    val F_Pic03_URL: String,
    val F_Pic04_URL: String,
    @SerializedName("F_Function＆Application") val application: String,
){
    fun getLocationList(): List<String>{
        return F_Location.split("；")
    }
}
