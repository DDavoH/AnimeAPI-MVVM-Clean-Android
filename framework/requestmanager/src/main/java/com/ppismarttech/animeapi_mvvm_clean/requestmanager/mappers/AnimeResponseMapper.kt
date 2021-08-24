package com.ppismarttech.animeapi_mvvm_clean.requestmanager

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.ppismarttech.animeapi_mvvm_clean.domain.Anime
import com.ppismarttech.animeapi_mvvm_clean.domain.AnimeDescriptions
import com.ppismarttech.animeapi_mvvm_clean.domain.AnimeTitles
import com.ppismarttech.animeapi_mvvm_clean.requestmanager.responses.AnimeDataDocumentDescriptionsResponse
import com.ppismarttech.animeapi_mvvm_clean.requestmanager.responses.AnimeDataDocumentTitlesResponse
import com.ppismarttech.animeapi_mvvm_clean.requestmanager.responses.AnimeResponse
import okhttp3.ResponseBody
import retrofit2.Response

fun ResponseBody.toDomainAnimeList(): List<Anime>  {
    
    val json = this.string()
    val jsonObject: JsonObject = JsonParser().parse(json).asJsonObject
    
    val gson = GsonBuilder().serializeNulls().create()
    val serialized = gson.fromJson(jsonObject, AnimeResponse::class.java)
   
    val mutableList = mutableListOf<Anime>()
    
    //Log.e(TAG, "toDomainAnimeList: ${serialized}")
    Log.e(TAG, "toDomainAnimeList: ${this.string()}")
    Log.e(TAG, "toDomainAnimeList: $this")
    
    serialized.data?.documents?.forEach {
        mutableList.add(Anime(it.anilist_id?:0, it.mal_id?:0, it.format?:0, it.status?:0, it.titles?.toDomainAnimeTitles(),
            it.descriptions?.toDomainAnimeDescriptions(),
            it.start_date, it.end_date, it.season_period ,it.season_year
            ,it.episodes_count, it.episode_duration, it.trailer_url, it.cover_image, it.cover_color, it.banner_image, it.genres, it.score, it.id))
    }
    
    var isAuthenticated = false
    //if(this.c!=401) isAuthenticated = true
    
    return mutableList
}

private val TAG = "AnimeResponseMapper"

fun AnimeDataDocumentTitlesResponse.toDomainAnimeTitles(): AnimeTitles {
    return AnimeTitles(this.en, this.jp)
}

fun Map<String,String>.toDomainAnimeTitles() : AnimeTitles{
    return AnimeTitles(this.get("en"))
}

fun AnimeDataDocumentDescriptionsResponse.toDomainAnimeDescriptions(): AnimeDescriptions{
    return AnimeDescriptions(this.en)
}

fun Map<String,String>.toDomainAnimeDescriptions() : AnimeDescriptions{
    return AnimeDescriptions(this.get("en"))
}