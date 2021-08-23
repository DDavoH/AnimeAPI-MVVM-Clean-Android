package com.ppismarttech.animeapi_mvvm_clean.domain

data class Anime (
        val anilist_id : Int,
        val mal_id : Int,
        val format : Int,
        val status : Int,
        val titles : AnimeTitles,
        val descriptions : AnimeDescriptions,
        val start_date : String,
        val end_date : String,
        val season_period : Int,
        val season_year : Int,
        val episodes_count : Int,
        val episode_duration : Int,
        val trailer_url : String,
        val cover_image : String,
        val cover_color : String,
        val banner_image : String,
        val genres : List<String>,
        val score : Int,
        val id : Int
)

data class AnimeTitles (
        val en : String,
        val jp : String
)

data class AnimeDescriptions (
        val en : String
)