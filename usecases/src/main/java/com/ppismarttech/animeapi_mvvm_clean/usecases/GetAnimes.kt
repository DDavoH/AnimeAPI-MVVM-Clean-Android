package com.ppismarttech.animeapi_mvvm_clean.usecases

import com.ppismarttech.animeapi_mvvm_clean.data.AnimeRepository

class GetAnimes(private val animeRepository: AnimeRepository) {
    
    fun invoke() = animeRepository.getAnimes()
    
}