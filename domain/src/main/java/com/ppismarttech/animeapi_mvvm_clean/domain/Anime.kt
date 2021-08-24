package com.ppismarttech.animeapi_mvvm_clean.domain

data class Anime (
        val anilist_id : Int=0,
        val mal_id : Int=0,
        val format : Int=0,
        val status : Int=0,
        val titles : AnimeTitles?= AnimeTitles(),
        val descriptions : AnimeDescriptions?= AnimeDescriptions(),
        val start_date : String?="",
        val end_date : String?="",
        val season_period : Int?=0,
        val season_year : Int?=0,
        val episodes_count : Int?=0,
        val episode_duration : Int?=0,
        val trailer_url : String?="",
        val cover_image : String?="",
        val cover_color : String?="",
        val banner_image : String?="",
        val genres : List<String>?= mutableListOf(),
        val score : Int?=0,
        val id : Int?=0
)

data class AnimeTitles (
        val en : String?="",
        val jp : String?=""
)

data class AnimeDescriptions (
        val en : String?=""
)