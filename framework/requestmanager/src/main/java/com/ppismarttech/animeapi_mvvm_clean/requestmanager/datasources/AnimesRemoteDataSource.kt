package com.ppismarttech.animeapi_mvvm_clean.requestmanager.datasources

import com.ppismarttech.animeapi_mvvm_clean.domain.Anime
import com.ppismarttech.animeapi_mvvm_clean.requestmanager.APIServices
import com.ppismarttech.animeapi_mvvm_clean.requestmanager.responses.AnimeResponse
import com.ppismarttech.animeapi_mvvm_clean.requestmanager.toDomainAnimeList
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class AnimesRemoteDataSource (
    private val apiService: APIServices
){
    fun getAnimes(): Observable<List<Anime>> {
        return apiService
            .getAnimes()
            .map(AnimeResponse::toDomainAnimeList)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}