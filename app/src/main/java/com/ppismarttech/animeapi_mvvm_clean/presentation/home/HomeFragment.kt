package com.ppismarttech.animeapi_mvvm_clean.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ppismarttech.animeapi_mvvm_clean.R
import com.ppismarttech.animeapi_mvvm_clean.databinding.HomeFragmentBinding
import com.ppismarttech.animeapi_mvvm_clean.domain.Anime
import com.ppismarttech.animeapi_mvvm_clean.presentation.home.adapters.AnimesAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class HomeFragment : Fragment() {
    
    private val viewModel: HomeViewModel by viewModels()
    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!
    
    private val adapter = AnimesAdapter()
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        /*binding.appbar.setVisibility(View.VISIBLE)
        binding.loader.getRoot().findViewById(R.id.loader).setVisibility(View.GONE)*/
        
        viewModel.getAnimes()
        configureRecyclerView()
        observeData()
    }
    
    private fun configureRecyclerView(){
        binding.rv.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.rv.setHasFixedSize(true)
        binding.rv.adapter = adapter
        adapter.setOnItemClickListener(object : AnimesAdapter.OnItemClickListener{
            override fun onItemClick(anime: Anime, position: Int) {
                findNavController().navigate(R.id.action_homeFragment_to_animeDetailsFragment)
            }
        })
    }
    
    private fun observeData() {
        viewModel.animeList().observe( viewLifecycleOwner , { list->
            adapter.submitList(list)
        })
    }
    
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}