package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemBinding

class CharacterAdapter(
    private val list: ArrayList<Character>,
    private val onClick: (position: Int) -> Unit
) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class CharacterViewHolder(private var binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            itemView.setOnClickListener {
                onClick(adapterPosition)
            }

            binding.tvTitle.text = character.title
            binding.tvDesc.text = character.desc
            Glide.with(binding.image).load(character.img).into(binding.image)
        }
    }
}