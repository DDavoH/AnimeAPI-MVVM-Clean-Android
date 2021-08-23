package com.ppismarttech.animeapi_mvvm_clean

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
//import com.ppismarttech.animeapi_mvvm_clean.di.ApplicationComponent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    
    //private lateinit var appComponent : ApplicationComponent
    
    private val viewModel :MainViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        //appComponent.inject(this)
        
        viewModel.getAnimes()
        
        viewModel.animeList().observe(this, Observer { list->
            Log.e(TAG, "onCreate: $list")
        })
    }
    
    companion object {
        private const val TAG = "MainActivity"
    }
}