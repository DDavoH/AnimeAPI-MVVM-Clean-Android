package com.ppismarttech.animeapi_mvvm_clean.requestmanager

import io.reactivex.rxjava3.core.Single
import okhttp3.ResponseBody
import retrofit2.http.GET

interface APIServices {
    @GET("anime")
    fun getAnimes(): Single<ResponseBody>
}