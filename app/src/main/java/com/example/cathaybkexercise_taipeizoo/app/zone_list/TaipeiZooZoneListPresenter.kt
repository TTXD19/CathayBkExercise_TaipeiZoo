package com.example.cathaybkexercise_taipeizoo.app.zone_list

import com.example.data.repository.taipei_zoo.ITaipeiZooRepository
import javax.inject.Singleton


class TaipeiZooZoneListPresenter(
    private val view: TaipeiZooZoneListContracts.View,
    private val taipeiZooRepository: ITaipeiZooRepository
) : TaipeiZooZoneListContracts.Presenter {

    override suspend fun fetchTaipeiZooZoneList() {
        val result = taipeiZooRepository.getZooZoneList()
        view.onTaipeiZooZoneListUpdate()
    }
}