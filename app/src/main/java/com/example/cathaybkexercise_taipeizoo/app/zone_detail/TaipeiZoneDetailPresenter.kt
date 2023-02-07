package com.example.cathaybkexercise_taipeizoo.app.zone_detail

import com.example.cathaybkexercise_taipeizoo.di.PresenterProvider
import com.example.data.data_source.DataResult
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class TaipeiZoneDetailPresenter(
    private val view: TaipeiZoneDetailContracts.View
) : TaipeiZoneDetailContracts.Presenter {

    companion object{
        private const val MAX_DATA_LIMIT = 110
        private const val INITIAL_OFFSET = 0
    }

    private val taipeiZooRepository = EntryPointAccessors.fromApplication(
        view.getFragmentContext(),
        PresenterProvider.TaipeiZooPresenterProvider::class.java
    ).taipeiZooRepository()

    override suspend fun fetchZoneDetail() {
        val result = taipeiZooRepository.getZonePlantDetails(offset = INITIAL_OFFSET, limit = MAX_DATA_LIMIT)
        withContext(Dispatchers.Main) {
            if (result is DataResult.Success) {
                view.onZoneDetailUpdate(result.data)
                return@withContext
            }
            // Delay to prevent failure loading to fast
            delay(2000)
            view.onZoneDetailUpdateFailed()
        }
    }
}