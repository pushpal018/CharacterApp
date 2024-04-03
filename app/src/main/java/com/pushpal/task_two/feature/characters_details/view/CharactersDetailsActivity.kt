package com.pushpal.task_two.feature.characters_details.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.pushpal.task_two.databinding.ActivityCharacterDetailsBinding
import com.pushpal.task_two.feature.characters_list.view_model.CharactersItemUiModel

class CharactersDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCharacterDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val characterUiModel = intent.getSerializableExtra("character") as CharactersItemUiModel

        Glide.with(binding.imageViewFeatured)
            .load(characterUiModel.profileImage)
            .into(binding.imageViewFeatured)

        binding.textViewTitle.text = characterUiModel.firstName
        binding.textViewDate.text = characterUiModel.lastName
        binding.textViewExcerpt.text = characterUiModel.dateOfBirth

    }
}