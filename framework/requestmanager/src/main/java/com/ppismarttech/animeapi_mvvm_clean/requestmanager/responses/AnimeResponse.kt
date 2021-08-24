package com.ppismarttech.animeapi_mvvm_clean.requestmanager.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnimeResponse (
    @SerializedName("status_code") val status_code:Int ? = 0,
    @SerializedName("message") val message : String ? = "" ,
    @SerializedName("data") val data : AnimeDataResponse ? = null,
    @SerializedName("version") val version : Int ?=0
) : Parcelable

@Parcelize
data class AnimeDataResponse (
    @SerializedName("current_page") val current_page : Int ?=0,
    @SerializedName("count") val count : Int ?=0,
    @SerializedName("documents") val documents : List<AnimeDataDocumentResponse> ?=null,
    @SerializedName("last_page") val last_page : Int ?=0
) : Parcelable

@Parcelize
data class AnimeDataDocumentResponse (
    @SerializedName("anilist_id") val anilist_id : Int?=0,
    @SerializedName("mal_id") val mal_id : Int?=0,
    @SerializedName("format") val format : Int?=0,
    @SerializedName("status") val status : Int?=0,
    @SerializedName("titles") val titles : AnimeDataDocumentTitlesResponse?=null,
    @SerializedName("descriptions") val descriptions : AnimeDataDocumentDescriptionsResponse?=null,
    @SerializedName("start_date") val start_date : String?="",
    @SerializedName("end_date") val end_date : String?="",
    @SerializedName("season_period") val season_period : Int?=0,
    @SerializedName("season_year") val season_year : Int?=0,
    @SerializedName("episodes_count") val episodes_count : Int?=0,
    @SerializedName("episode_duration") val episode_duration : Int?=0,
    @SerializedName("trailer_url") val trailer_url : String?="",
    @SerializedName("cover_image") val cover_image : String?="",
    @SerializedName("cover_color") val cover_color : String?="",
    @SerializedName("banner_image") val banner_image : String?="",
    @SerializedName("genres") val genres : List<String>?= emptyList(),
    @SerializedName("score") val score : Int?=0,
    @SerializedName("id") val id : Int?=0
) : Parcelable

@Parcelize
data class AnimeDataDocumentTitlesResponse (
    @SerializedName("en") val en : String?="",
    @SerializedName("jp") val jp : String?="",
    @SerializedName("it") val it: String?=""
): Parcelable

@Parcelize
data class AnimeDataDocumentDescriptionsResponse (
    @SerializedName("en") val en : String?="",
    @SerializedName("it")  val it: String?=""
): Parcelable