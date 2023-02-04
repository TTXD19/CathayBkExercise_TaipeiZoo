package com.example.data.repository

import com.example.data.repository.taipei_zoo.ITaipeiZooRepository
import com.example.data.repository.taipei_zoo.TaipeiZooRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindTransportRemoteDataSource(taipeiZooRepository: TaipeiZooRepository): ITaipeiZooRepository
}