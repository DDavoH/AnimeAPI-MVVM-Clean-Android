package com.ppismarttech.animeapi_mvvm_clean.requestmanager

import com.ppismarttech.animeapi_mvvm_clean.domain.Anime
import com.ppismarttech.animeapi_mvvm_clean.domain.AnimeDescriptions
import com.ppismarttech.animeapi_mvvm_clean.domain.AnimeTitles
import com.ppismarttech.animeapi_mvvm_clean.requestmanager.responses.AnimeDataDocumentDescriptionsResponse
import com.ppismarttech.animeapi_mvvm_clean.requestmanager.responses.AnimeDataDocumentTitlesResponse
import com.ppismarttech.animeapi_mvvm_clean.requestmanager.responses.AnimeResponse

fun AnimeResponse.toDomainAnimeList(): List<Anime>  {
    val mutableList = mutableListOf<Anime>()
    
    this.data?.documents?.forEach {
        mutableList.add(Anime(it.anilist_id?:0, it.mal_id?:0, it.format?:0, it.status?:0, it.titles?.toDomainAnimeTitles(),
            it.descriptions?.toDomainAnimeDescriptions(),
            it.start_date, it.end_date, it.season_period ,it.season_year
            ,it.episodes_count, it.episode_duration, it.trailer_url, it.cover_image, it.cover_color, it.banner_image, it.genres, it.score, it.id))
    }
    return mutableList
}

fun AnimeDataDocumentTitlesResponse.toDomainAnimeTitles(): AnimeTitles {
    return AnimeTitles(this.en, this.jp)
}

fun AnimeDataDocumentDescriptionsResponse.toDomainAnimeDescriptions(): AnimeDescriptions{
    return AnimeDescriptions(this.en)
}

fun Map<String,String>.toDomainAnimeDescriptions() : AnimeDescriptions{
    return AnimeDescriptions(this.get("en"))
}