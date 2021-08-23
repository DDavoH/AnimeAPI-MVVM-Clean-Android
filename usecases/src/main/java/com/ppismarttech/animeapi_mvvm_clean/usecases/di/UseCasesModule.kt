package com.ppismarttech.animeapi_mvvm_clean.usecases.di

import com.ppismarttech.animeapi_mvvm_clean.data.AnimeRepository
import com.ppismarttech.animeapi_mvvm_clean.usecases.GetAnimes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {
    
    @Provides
    @Singleton
    fun providesGetAnimes(animeRepository: AnimeRepository): GetAnimes = GetAnimes(animeRepository)
    
}