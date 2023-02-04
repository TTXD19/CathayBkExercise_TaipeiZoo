package com.example.data.data_source

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.data.data_source.taipei_zoo.ITaipeiZooDataSource
import com.example.data.data_source.taipei_zoo.TaipeiZooDataSource

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindTransportRemoteDataSource(taipeiZooDataSource: TaipeiZooDataSource): ITaipeiZooDataSource
}