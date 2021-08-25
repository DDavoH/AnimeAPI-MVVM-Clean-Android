package com.ppismarttech.animeapi_mvvm_clean

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ppismarttech.animeapi_mvvm_clean.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    
    private val viewModel :MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        
        //Asignar nuevo toolbar
        setSupportActionBar(binding.toolbar)
        
        //Declarar objetos
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        
        //Configurar toolbar con el nav controller
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        findViewById<Toolbar>(R.id.toolbar)
            .setupWithNavController(navController, appBarConfiguration)
        
        //Ocultar/Mostrar toolbar
        navController.addOnDestinationChangedListener{ _, destination, _ ->
            run {
                if (destination.id == R.id.homeFragment) {
                    binding.toolbar.visibility = View.GONE
                } else {
                    binding.toolbar.visibility = View.VISIBLE
                }
            }
        }
    }
    
    
}