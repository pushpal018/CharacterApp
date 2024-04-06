package com.pushpal.task_two.feature.characters_list.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pushpal.task_two.R
import com.pushpal.task_two.databinding.ItemCharacterPostBinding
import com.pushpal.task_two.feature.characters_details.view.CharactersDetailsActivity
import com.pushpal.task_two.feature.characters_list.view_model.CharactersItemUiModel

class CharactersRecyclerViewAdapter(private val characterList: List<CharactersItemUiModel>) :
    RecyclerView.Adapter<CharactersRecyclerViewAdapter.CharacterPostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterPostViewHolder {
        val binding = ItemCharacterPostBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterPostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterPostViewHolder, position: Int) {
        val characters = characterList[position]
        holder.bind(characters)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    inner class CharacterPostViewHolder(private val binding: ItemCharacterPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(characters: CharactersItemUiModel) {
            Glide.with(itemView)
                .load(characters.profileImage)
                .placeholder(R.drawable.user)
                .into(binding.profileImage)

            val fullName = characters.name.split(" ")
            val firstName = fullName[0]
            val lastName = fullName[1]

            binding.tvFirstName.text = firstName

            binding.tvLastName.text = lastName
            binding.tvMobileNumber.text = characters.dateOfBirth

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, CharactersDetailsActivity::class.java)
                intent.putExtra("character", characters)
                binding.root.context.startActivity(intent)
            }
        }
    }
}