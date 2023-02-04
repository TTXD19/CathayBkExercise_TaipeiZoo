package com.example.cathaybkexercise_taipeizoo.di

import com.example.cathaybkexercise_taipeizoo.app.zone_list.TaipeiZooZoneListContracts
import com.example.cathaybkexercise_taipeizoo.app.zone_list.TaipeiZooZoneListPresenter
import com.example.data.repository.taipei_zoo.ITaipeiZooRepository
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

class PresenterProvider {
    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface TaipeiZooPresenterProvider {
        fun taipeiZooRepository(): ITaipeiZooRepository
    }
}