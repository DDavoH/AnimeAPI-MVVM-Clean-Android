package com.ppismarttech.animeapi_mvvm_clean.presentation.animeDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ppismarttech.animeapi_mvvm_clean.R

class AnimeDetailsFragment : Fragment() {
    
    companion object {
        fun newInstance() = AnimeDetailsFragment()
    }
    
    private lateinit var viewModel: AnimeDetailsViewModel
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.anime_details_fragment, container, false)
    }
    
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnimeDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }
    
}