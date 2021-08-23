package com.ppismarttech.animeapi_mvvm_clean.di

import com.ppismarttech.animeapi_mvvm_clean.data.AnimeRepository
import com.ppismarttech.animeapi_mvvm_clean.requestmanager.datasources.AnimesRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesAnimeRepository(animesRemoteDataSource: AnimesRemoteDataSource) = AnimeRepository(animesRemoteDataSource)

}