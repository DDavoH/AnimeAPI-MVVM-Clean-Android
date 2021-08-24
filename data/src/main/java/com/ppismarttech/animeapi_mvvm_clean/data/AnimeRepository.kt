package com.ppismarttech.animeapi_mvvm_clean.data

import com.ppismarttech.animeapi_mvvm_clean.requestmanager.datasources.AnimesRemoteDataSource

class AnimeRepository(private val animesRemoteDataSource: AnimesRemoteDataSource) {
    
    fun getAnimes() = animesRemoteDataSource.getAnimes()
    
}