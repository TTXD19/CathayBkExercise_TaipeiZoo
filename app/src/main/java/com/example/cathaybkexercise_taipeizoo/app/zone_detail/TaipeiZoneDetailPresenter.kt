package com.example.cathaybkexercise_taipeizoo.app.zone_detail

import com.example.cathaybkexercise_taipeizoo.di.PresenterProvider
import com.example.data.data_source.DataResult
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaipeiZoneDetailPresenter(
    private val view: TaipeiZoneDetailContracts.View
) : TaipeiZoneDetailContracts.Presenter {

    private val taipeiZooRepository = EntryPointAccessors.fromApplication(
        view.getFragmentContext(),
        PresenterProvider.TaipeiZooPresenterProvider::class.java
    ).taipeiZooRepository()

    override suspend fun fetchZoneDetail() {
        val result = taipeiZooRepository.getZonePlantDetails(offset = 0, 20)
        withContext(Dispatchers.Main) {
            if (result is DataResult.Success) {
                view.onZoneDetailUpdate()
            }
        }
    }
}