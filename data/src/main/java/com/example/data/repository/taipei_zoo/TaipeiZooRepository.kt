package com.example.data.repository.taipei_zoo

import com.example.data.data_source.taipei_zoo.ITaipeiZooDataSource
import javax.inject.Inject

class TaipeiZooRepository @Inject constructor(
    private val taiZooDataSource: ITaipeiZooDataSource
): ITaipeiZooRepository {
}