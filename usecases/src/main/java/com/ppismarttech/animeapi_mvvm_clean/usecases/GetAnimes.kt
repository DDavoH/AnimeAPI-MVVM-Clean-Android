package com.ppismarttech.animeapi_mvvm_clean.usecases

import com.ppismarttech.animeapi_mvvm_clean.data.AnimeRepository
import com.ppismarttech.animeapi_mvvm_clean.domain.Anime
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetAnimes(private val animeRepository: AnimeRepository) {
    
    fun invoke(): Single<List<Anime>> = animeRepository.getAnimes()
    
}