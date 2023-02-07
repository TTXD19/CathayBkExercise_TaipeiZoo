package com.example.cathaybkexercise_taipeizoo.app

import com.example.model.taipei_zoo.PlantDetail
import com.example.model.taipei_zoo.ZooZoneDetail

interface TaipeiZooActivityHandler {
    fun goTaipeiZooZoneList()
    fun goTaipeiZooZoneDetail(zooZoneDetail: ZooZoneDetail)
    fun goPlantDetail(plantDetail: PlantDetail)
}