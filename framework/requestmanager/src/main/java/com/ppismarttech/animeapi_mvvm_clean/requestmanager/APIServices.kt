package com.ppismarttech.animeapi_mvvm_clean.requestmanager

import com.ppismarttech.animeapi_mvvm_clean.requestmanager.responses.AnimeResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface APIServices {
    @GET("anime")
    fun getAnimes(): Single<AnimeResponse>
}