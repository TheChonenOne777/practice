package com.example.practice.di

import com.example.practice.network.NetworkClient
import com.example.practice.network.RetrofitClient
import com.example.practice.network.list.MockDataSource
import com.example.practice.network.list.RemoteListDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Singleton
    @Binds
    fun networkClient(client: RetrofitClient): NetworkClient

    @Singleton
    @Binds
    fun remoteListDataSource(dataSource: MockDataSource): RemoteListDataSource //TODO: replace once mock data source deleted
}