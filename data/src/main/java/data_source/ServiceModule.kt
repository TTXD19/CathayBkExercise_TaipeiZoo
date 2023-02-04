package data_source

import com.example.data.dependency_injection.RetrofitManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import data_source.taipei_zoo.TaipeiZooServices
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {
    @Singleton
    @Provides
    fun provideAuthApiService(networkManager: RetrofitManager): TaipeiZooServices {
        return networkManager.getApiServices(TaipeiZooServices::class.java)
    }
}