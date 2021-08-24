package com.ppismarttech.animeapi_mvvm_clean

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ppismarttech.animeapi_mvvm_clean.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    

    private val viewModel :MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    
    private val adapter = AnimesAdapter()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        
        binding.rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rv.setHasFixedSize(true)
        binding.rv.adapter = adapter

        
        viewModel.getAnimes()
        
        viewModel.animeList().observe(this,{ list->
            adapter.submitList(list)
        })
    }
    
    companion object {
        private const val TAG = "MainActivity"
    }
}