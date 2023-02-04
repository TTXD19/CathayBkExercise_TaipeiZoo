package data_source

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import data_source.taipei_zoo.ITaipeiZooDataSource
import data_source.taipei_zoo.TaipeiZooDataSource
import data_source.taipei_zoo.TaipeiZooServices
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideDataSourceModule(taipeiZooService: TaipeiZooServices): ITaipeiZooDataSource {
        return TaipeiZooDataSource(taipeiZooService)
    }
}