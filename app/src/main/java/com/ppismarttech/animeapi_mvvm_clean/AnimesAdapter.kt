package com.ppismarttech.animeapi_mvvm_clean

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ppismarttech.animeapi_mvvm_clean.databinding.RowAnimeBinding
import com.ppismarttech.animeapi_mvvm_clean.domain.Anime

class AnimesAdapter : ListAdapter<Anime, RecyclerView.ViewHolder>(DiffCallback()) {
    
    private var listener: OnItemClickListener? = null
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_anime,
                parent,
                false
            )
        )
    }
    
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).bind(getItem(position), position)
    }
    private val TAG = "AnimesAdapter"
    inner class ItemViewHolder(private val binding: RowAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Anime, position: Int) {
            Log.e(TAG, "bind: $item")
            binding.title.text = item.titles?.en
            Glide.with(binding.root).load(item.cover_image).fitCenter().into(binding.image)
            
            binding.layout.setOnClickListener {
                listener?.onItemClick(item, position)
            }
            
        }
    }
    
    interface OnItemClickListener {
        fun onItemClick(superTag: Anime, position: Int)
    }
    
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
    
    class DiffCallback : DiffUtil.ItemCallback<Anime>() {
        override fun areItemsTheSame(
            oldItem: Anime,
            newItem: Anime
        ): Boolean {
            return oldItem == newItem
        }
        
        override fun areContentsTheSame(
            oldItem: Anime,
            newItem: Anime
        ): Boolean {
            return oldItem == newItem
        }
    }
}