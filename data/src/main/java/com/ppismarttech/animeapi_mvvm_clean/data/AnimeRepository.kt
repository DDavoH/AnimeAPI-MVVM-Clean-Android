package com.ppismarttech.animeapi_mvvm_clean.data

import com.ppismarttech.animeapi_mvvm_clean.domain.Anime
import com.ppismarttech.animeapi_mvvm_clean.requestmanager.datasources.AnimesRemoteDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class AnimeRepository(private val animesRemoteDataSource: AnimesRemoteDataSource) {
    
    fun getAnimes(): Single<List<Anime>> = animesRemoteDataSource.getAnimes()
    
}