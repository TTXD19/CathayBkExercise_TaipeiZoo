package com.example.cathaybkexercise_taipeizoo.app.zone_detail

import android.content.Context
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cathaybkexercise_taipeizoo.di.PresenterProvider
import com.example.data.data_source.DataResult
import com.example.model.taipei_zoo.PlantDetail
import dagger.hilt.android.EntryPointAccessors
import okio.IOException
import retrofit2.HttpException

class TaipeiPlantPagingSource(context: Context) : PagingSource<Int, PlantDetail>() {

    companion object {
        private const val INITIAL_OFFSET = 0
        private const val ITEM_LIMIT_SIZE = 20
    }

    private val taipeiZooRepository = EntryPointAccessors.fromApplication(
        context,
        PresenterProvider.TaipeiZooPresenterProvider::class.java
    ).taipeiZooRepository()

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PlantDetail> {
        val offset = params.key ?: INITIAL_OFFSET
        try {
            val dataResult = taipeiZooRepository.getZonePlantDetails(offset = offset, limit = ITEM_LIMIT_SIZE)
            if (dataResult is DataResult.Success) {
                val nextKey = if (dataResult.data.results.isEmpty()) null else offset + ITEM_LIMIT_SIZE
                return LoadResult.Page(
                    data = dataResult.data.results,
                    prevKey = null,
                    nextKey = nextKey
                )
            }
            return LoadResult.Error(Throwable())
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PlantDetail>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1)
                ?: anchorPage?.nextKey?.minus(1)
        }
    }

}