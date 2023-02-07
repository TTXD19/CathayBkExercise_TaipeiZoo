package com.example.cathaybkexercise_taipeizoo.app.zone_list

import com.example.cathaybkexercise_taipeizoo.di.PresenterProvider
import com.example.data.data_source.DataResult
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext


class TaipeiZooZoneListPresenter(
    private val view: TaipeiZooZoneListContracts.View,
) : TaipeiZooZoneListContracts.Presenter {

    private val taipeiZooRepository = EntryPointAccessors.fromApplication(
        view.getFragmentContext(),
        PresenterProvider.TaipeiZooPresenterProvider::class.java
    ).taipeiZooRepository()

    override suspend fun fetchTaipeiZooZoneList() {
        val result = taipeiZooRepository.getZooZoneList()
        withContext(Dispatchers.Main) {
            if (result is DataResult.Success) {
                view.onTaipeiZooZoneListUpdate(result.data)
                return@withContext
            }
            // Delay to prevent failure loading to fast
            delay(2000)
            view.onTaipeiZooZoneListUpdateFailed()
        }
    }
}