package com.mobile.test.data.di

import com.mobile.test.data.listCard.GetListCardRepositoryImpl
import com.mobile.test.data.listCard.ListCardDataSource
import com.mobile.test.domain.listCard.GetListCardRepopsitory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataDi {

    @Provides
    @Singleton
    fun providerListCardDataSource(
    ): ListCardDataSource {
        return ListCardDataSource()
    }

    @Provides
    @Singleton
    fun providerGetListCardRopositoryImpl(
        dataSource: ListCardDataSource
    ): GetListCardRepopsitory {
        return GetListCardRepositoryImpl(dataSource)
    }
}