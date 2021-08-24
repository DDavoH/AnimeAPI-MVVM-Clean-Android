package com.ppismarttech.animeapi_mvvm_clean

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ppismarttech.animeapi_mvvm_clean.domain.Anime
import com.ppismarttech.animeapi_mvvm_clean.usecases.GetAnimes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getAnimes: GetAnimes):ViewModel(){
    
    private val _animeList = MutableLiveData<List<Anime>>()
    
    fun getAnimes() = getAnimes.invoke().subscribe({
            it.let { animeList->
                _animeList.postValue(animeList)
            }
    },{
    
    })
    
    fun animeList(): LiveData<List<Anime>> {
        return _animeList
    }
    
    companion object {
        private const val TAG = "MainViewModel"
    }
    
}