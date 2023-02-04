package com.example.data.repository.taipei_zoo

import com.example.data.data_source.DataResult
import com.example.data.data_source.taipei_zoo.ITaipeiZooDataSource
import com.example.model.taipei_zoo.TaipeiZooResp
import java.lang.Exception
import javax.inject.Inject

class TaipeiZooRepository @Inject constructor(
    private val taipeiZooDataSource: ITaipeiZooDataSource
) : ITaipeiZooRepository {
    override suspend fun getZooZoneList(): DataResult<TaipeiZooResp> {
        try {
            val response = taipeiZooDataSource.getZooZoneList()
            if (response.isSuccessful) {
                response.body()?.also {
                    return DataResult.Success(it.result)
                }
            }
            return DataResult.Failure("Internet Error")
        } catch (e: Exception) {
            return DataResult.Error(e)
        }
    }
}