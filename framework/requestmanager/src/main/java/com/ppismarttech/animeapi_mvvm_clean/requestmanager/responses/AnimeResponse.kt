package com.ppismarttech.animeapi_mvvm_clean.requestmanager.responses

import com.google.gson.annotations.SerializedName

data class AnimeResponse (
    @SerializedName("status_code") val status_code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("data") val data : AnimeDataResponse,
    @SerializedName("version") val version : Int
)

data class AnimeDataResponse (
    @SerializedName("current_page") val current_page : Int,
    @SerializedName("count") val count : Int,
    @SerializedName("documents") val documents : List<AnimeDataDocumentResponse>,
    @SerializedName("last_page") val last_page : Int
)

data class AnimeDataDocumentResponse (
    @SerializedName("anilist_id") val anilist_id : Int,
    @SerializedName("mal_id") val mal_id : Int,
    @SerializedName("format") val format : Int,
    @SerializedName("status") val status : Int,
    @SerializedName("titles") val titles : AnimeDataDocumentTitlesResponse,
    @SerializedName("descriptions") val descriptions : AnimeDataDocumentDescriptionsResponse,
    @SerializedName("start_date") val start_date : String,
    @SerializedName("end_date") val end_date : String,
    @SerializedName("season_period") val season_period : Int,
    @SerializedName("season_year") val season_year : Int,
    @SerializedName("episodes_count") val episodes_count : Int,
    @SerializedName("episode_duration") val episode_duration : Int,
    @SerializedName("trailer_url") val trailer_url : String,
    @SerializedName("cover_image") val cover_image : String,
    @SerializedName("cover_color") val cover_color : String,
    @SerializedName("banner_image") val banner_image : String,
    @SerializedName("genres") val genres : List<String>,
    @SerializedName("score") val score : Int,
    @SerializedName("id") val id : Int
)

data class AnimeDataDocumentTitlesResponse (
    @SerializedName("en") val en : String,
    @SerializedName("jp") val jp : String
)

data class AnimeDataDocumentDescriptionsResponse (
    
    @SerializedName("en") val en : String
)